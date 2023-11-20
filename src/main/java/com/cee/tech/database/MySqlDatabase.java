package com.cee.tech.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDatabase implements Serializable {
    public static final String URL = "jdbc:mysql://localhost:3306/eticket";
    public static final String USER = "root";
    public static final String PASSWORD = "makutano";

    private static  MySqlDatabase database;
    private Connection connection;

    private MySqlDatabase() throws SQLException {
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static MySqlDatabase getInstance() throws SQLException {
        if(database == null)
            database = new MySqlDatabase();

        return database;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
