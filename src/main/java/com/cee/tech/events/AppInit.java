package com.cee.tech.events;

import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.TicketManagement;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;
import com.cee.tech.database.MySqlDatabase;
import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class AppInit implements ServletContextListener {

    public static<T> List<T> select(Class<T> filter) {
        try {
            Class<?> clazz = filter;
            System.out.println();
            System.out.println("Clazz>>>>>>>>>>" + clazz.getName());

            if (!clazz.isAnnotationPresent(DbTable.class))
                return new ArrayList<>();

            DbTable dbTable = clazz.getAnnotation(DbTable.class);
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("SELECT * FROM ")
                    .append(dbTable.name()).append(";");
            Connection conn = MySqlDatabase.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(stringBuilder.toString());

            ResultSet resultSet = preparedStatement.executeQuery();

            List<T> result = new ArrayList<>();

            while (resultSet.next()) {
                T object = (T) clazz.getDeclaredConstructor().newInstance();

                for (Field field : clazz.getDeclaredFields()) {
                    DbTableColumn dbColumn = field.getAnnotation(DbTableColumn.class);
                    if (dbColumn != null) {
                        String columnName = dbColumn.name();

                        Object value = resultSet.getObject(columnName);
                        field.setAccessible(true);
                        field.set(object, value);
                    }
                }

                result.add(object);
            }
            return result;
        } catch (SQLException | InvocationTargetException | IllegalArgumentException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("***************** Initializing Database **********************");

        Database database = Database.getDbInstance();

        try {
            Connection conn = MySqlDatabase.getInstance().getConnection();

            List<Class<?>> entities = new ArrayList<>();
            entities.add(User.class);

            for (Class<?> clazz : entities) {

                if (!clazz.isAnnotationPresent(DbTable.class))
                    continue;

                DbTable dbTable = clazz.getAnnotation(DbTable.class);

                StringBuilder sqlBuilder = new StringBuilder();
                sqlBuilder.append("create table if not exists ").append(dbTable.name()).append("(");
                for (Field field : clazz.getDeclaredFields()) {
                    if (!field.isAnnotationPresent(DbTableColumn.class))
                        continue;
                    DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                    sqlBuilder.append(dbTableColumn.name()).append(" ").append(dbTableColumn.definition()).append(" ").append(dbTableColumn.primaryKey()).append(" ").append(dbTableColumn.notNull()).append(",");
                }
                sqlBuilder.append(")");

                conn.prepareStatement(sqlBuilder.toString().replace(",)", ")")).executeUpdate();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

       database.getFixtures().add(new Fixture("Kenya Premier League","17:00 EAT", "Nyayo","Gor Mahia", "Shabana","27/10/2023"));
       database.getFixtures().add(new Fixture("Mozzart Cup","14:00 EAT", "MISC Kasarani","Kariobangi Sharks","Kakamega Homeboyz",  "1/11/2023"));

       //database.getTicketManagement().add(new TicketManagement("CAF Champions league",300, 100, 800, 100,200));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println();
        System.out.println();
        System.out.println("**************App killed*****************");
        System.out.println();
        System.out.println();

        try {
            MySqlDatabase database = MySqlDatabase.getInstance();
            if (database.getConnection() != null) {
                database.getConnection().close();
            }
        } catch (SQLException e) {
            System.out.println("Connection closed");
            throw new RuntimeException(e);
        }


    }
}
