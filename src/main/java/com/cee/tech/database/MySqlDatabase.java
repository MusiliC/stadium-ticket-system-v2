package com.cee.tech.database;

import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.helper.DBTableId;
import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.mysql.cj.jdbc.MysqlDataSource;

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

public class MySqlDatabase implements Serializable {
    public static final String URL = "jdbc:mysql://localhost:3306/eticket";
    public static final String USER = "root";
    public static final String PASSWORD = "makutano";

    private static MySqlDatabase database;
    private Connection connection;

    private MySqlDatabase() throws SQLException {

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        connection = dataSource.getConnection();

    }

    public static MySqlDatabase getInstance() throws SQLException {
        if (database == null)
            database = new MySqlDatabase();

        return database;
    }

    public static void updateSchema() {
        System.out.println(" ***************** Updating schema Database **********************");


        try {
            Connection conn = MySqlDatabase.getInstance().getConnection();

            List<Class<?>> entities = new ArrayList<>();
            entities.add(User.class);

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

                conn.prepareStatement(sqlBuilder.toString().replace(",)", ")")).executeUpdate();

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
                if (param.getClass().isAssignableFrom(int.class))
                    sqlStmt.setInt(paramIdx++, (Integer) param);
                else if (param.getClass().isAssignableFrom(Long.class))
                    sqlStmt.setLong(paramIdx++, (long) param);
                else if (param.getClass().isAssignableFrom(Date.class))
                    sqlStmt.setDate(paramIdx++, new java.sql.Date(((Date) param).getTime()));
                else
                    sqlStmt.setString(paramIdx++, (String) param);
            }

            sqlStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
