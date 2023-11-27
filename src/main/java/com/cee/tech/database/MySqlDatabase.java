package com.cee.tech.database;

import com.cee.tech.app.model.entity.BookTicket;
import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.TicketManagement;
import com.cee.tech.app.model.entity.User;
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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Singleton
@Startup()
public class MySqlDatabase implements Serializable {
    private Connection connection;

    @PostConstruct
    private void init() throws SQLException, NamingException {
        Context ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:jboss/datasources/eticket");
        connection = dataSource.getConnection();

        System.out.println("Executed. on start up!!");

        this.updateSchema();
    }


    private void updateSchema() {
        System.out.println(" ***************** Updating schema Database **********************");


        try {

            List<Class<?>> entities = new ArrayList<>();
            entities.add(User.class);
            entities.add(Fixture.class);
            entities.add(TicketManagement.class);
            entities.add(BookTicket.class);

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
                else
                    sqlStmt.setString(paramIdx++, (String) param);
            }

            sqlStmt.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void saveOrUpdate(Object entity) {
//
//        try {
//            Class<?> clazz = entity.getClass();
//            if (!clazz.isAnnotationPresent(DbTable.class))
//                return;
//
//            DbTable dbTable = clazz.getAnnotation(DbTable.class);
//
//            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
//            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
//
//
//            StringBuilder columnBuilder = new StringBuilder();
//            StringBuilder paramPlaceHolderBuilder = new StringBuilder();
//            List<Object> parameters = new ArrayList<>();
//
//            for (Field field : fields) {
//                if (!field.isAnnotationPresent(DbTableColumn.class) || field.isAnnotationPresent(DBTableId.class))
//                    continue;
//
//                field.setAccessible(true);
//                if (field.get(entity) == null)
//                    continue;
//
//                DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);
//
//                columnBuilder.append(dbTableColumn.name()).append(",");
//                paramPlaceHolderBuilder.append("?").append(",");
//                parameters.add(field.get(entity));
//
//            }
//
//            String queryBuilder = "insert into " +
//                    dbTable.name() +
//                    "(" +
//                    columnBuilder +
//                    ")" +
//                    " values(" +
//                    paramPlaceHolderBuilder +
//                    ")";
//
//            String query = queryBuilder.replace(",)", ")");
//            System.out.println("Query: " + query);
//
//            PreparedStatement sqlStmt = connection.prepareStatement(query);
//
//            int paramIdx = 1;
//            for (Object param : parameters) {
//                if (param.getClass().isAssignableFrom(int.class))
//                    sqlStmt.setInt(paramIdx++, (Integer) param);
//                else if (param.getClass().isAssignableFrom(Long.class))
//                    sqlStmt.setLong(paramIdx++, (long) param);
//                else if (param.getClass().isAssignableFrom(Date.class))
//                    sqlStmt.setDate(paramIdx++, new java.sql.Date(((Date) param).getTime()));
//                else
//                    sqlStmt.setString(paramIdx++, (String) param);
//            }
//
//            sqlStmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static  <T> List<T> fetch(T filter){
        return new ArrayList<>();
    }

    public static  <T> T fetchSingle(T filter){
        return filter;
    }


    public Connection getConnection() {
        return connection;
    }

    @PreDestroy
    public void closeConnection(){
        try {
            if (connection != null)
                connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
