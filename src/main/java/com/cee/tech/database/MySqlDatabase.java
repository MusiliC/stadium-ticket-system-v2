package com.cee.tech.database;

import com.cee.tech.app.model.entity.*;
import com.cee.tech.database.helper.DBTableId;
import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//@Singleton
//@Startup()
public class MySqlDatabase implements Serializable {
    private Connection connection;

//    @PostConstruct
//    private void init() throws SQLException, NamingException {
//
//        System.out.println("Executed. on start up!!");
//
//        this.updateSchema();
//    }


    private void updateSchema() {
        System.out.println(" ***************** Updating schema Database **********************");


        try {

            List<Class<?>> entities = new ArrayList<>();
            entities.add(User.class);
            entities.add(Fixture.class);
            entities.add(TicketManagement.class);
            entities.add(BookTicket.class);
            entities.add(Audit.class);

            for (Class<?> clazz : entities) {

                if (!clazz.isAnnotationPresent(DbTable.class))
                    continue;

                System.out.println("************ Created table" + clazz.getSimpleName() + " *******************");

                DbTable dbTable = clazz.getAnnotation(DbTable.class);

                StringBuilder sqlBuilder = new StringBuilder();
                sqlBuilder.append("create table if not exists ").append(dbTable.name()).append("(");

                List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));

                fields.addAll(Arrays.asList(clazz.getDeclaredFields()));


                for (Field field : fields) {
                    if (!field.isAnnotationPresent(DbTableColumn.class))
                        continue;

                    DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                    sqlBuilder.append(dbTableColumn.name()).append(" ")
                            .append(dbTableColumn.definition())
                            .append(field.isAnnotationPresent(DBTableId.class) ? " NOT NULL AUTO_INCREMENT PRIMARY KEY" : "")
                            .append(",");
                }


                sqlBuilder.append(")");

                String tableSql = sqlBuilder.toString().replace(",)", ")");

                System.out.println("Created table: " + tableSql);

                connection.prepareStatement(sqlBuilder.toString().replace(",)", ")")).executeUpdate();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public void saveOrUpdate(Object entity) {

        try {

            Class<?> clazz = entity.getClass();
            if (!clazz.isAnnotationPresent(DbTable.class))
                return;

            DbTable dbTable = clazz.getAnnotation(DbTable.class);

            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            StringBuilder columnBuilder = new StringBuilder();
            StringBuilder paramPlaceHolderBuilder = new StringBuilder();
            StringBuilder values = new StringBuilder();
            List<Object> parameters = new ArrayList<>();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(DbTableColumn.class) || field.isAnnotationPresent(DBTableId.class))
                    continue;

                field.setAccessible(true);
                if (field.get(entity) == null)
                    continue;

                DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                columnBuilder.append(dbTableColumn.name()).append(",");
                paramPlaceHolderBuilder.append("?").append(",");
                parameters.add(field.get(entity));



            }

            String queryBuilder = "insert into " +
                    dbTable.name() +
                    "(" +
                    columnBuilder +
                    ")" +
                    " values(" +
                    paramPlaceHolderBuilder +
                    ")";

            String query = queryBuilder.replace(",)", ")");
            System.out.println("Query: " + query);

            PreparedStatement sqlStmt = connection.prepareStatement(query);

            int paramIdx = 1;
            for (Object param : parameters) {
                if (param.getClass().isAssignableFrom(BigDecimal.class))
                    sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
                else if (param.getClass().isAssignableFrom(Long.class))
                    sqlStmt.setLong(paramIdx++, (long) param);
                else if (param.getClass().isAssignableFrom(Integer.class))
                    sqlStmt.setInt(paramIdx++, (int) param);
                else if (param.getClass().isAssignableFrom(Date.class))
                    sqlStmt.setDate(paramIdx++, new java.sql.Date(((Date) param).getTime()));
                else if (param.getClass().isEnum())
                    sqlStmt.setString(paramIdx++, ((Enum<?>) param).name());
                else
                    sqlStmt.setString(paramIdx++, (String) param);
            }

            sqlStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public <T> List<T> fetch(T filter) {
        System.out.println("starting select/................");
        try {

            Class<?> clazz = (Class<?>) filter;

            if (!clazz.isAnnotationPresent(DbTable.class))
                return new ArrayList<>();

            DbTable dbTable = clazz.getAnnotation(DbTable.class);
            StringBuilder stringBuilder = new StringBuilder();

            System.out.println(stringBuilder.toString());

            stringBuilder.append("SELECT * FROM ")
                    .append(dbTable.name()).append(";");

            PreparedStatement preparedStatement=connection.prepareStatement(stringBuilder.toString());

            System.out.println("executing query begins for table/................ " + dbTable.name());
            ResultSet resultSet = preparedStatement.executeQuery();

            List<T> result = new ArrayList<>();


            while (resultSet.next()) {
                T object = (T) clazz.getDeclaredConstructor().newInstance();

                for (Field field : clazz.getDeclaredFields()) {
                    DbTableColumn dbColumn = field.getAnnotation(DbTableColumn.class);
                    if (dbColumn != null) {
                        String columnName = dbColumn.name();

                        //String id = resultSet.getInt("id");
                        Object value = resultSet.getObject(columnName);

                        if (value instanceof java.sql.Date && field.getType().equals(java.util.Date.class)) {
                            value = new java.util.Date(((java.sql.Date) value).getTime());
                        }

                        // Convert String to enum if needed
                        if (field.getType().isEnum() && value instanceof String) {
                            value = Enum.valueOf((Class<Enum>) field.getType(), (String) value);
                        }

                        field.setAccessible(true);
                        field.set(object, value);
                    }
                }

                result.add(object);
            }
            return result;


        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void delete(Class<?> clazz, Object id) {
        if (!clazz.isAnnotationPresent(DbTable.class))
            return;

        DbTable dbTable = clazz.getAnnotation(DbTable.class);


        String sqlStm = "DELETE FROM " + dbTable.name() + " WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlStm)) {
            if (id instanceof Integer)
                preparedStatement.setInt(1, (Integer) id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public Connection getConnection() {
        return connection;
    }

    @PreDestroy
    public void closeConnection() {
        try {
            if (connection != null)
                connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
