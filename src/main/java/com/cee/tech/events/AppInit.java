package com.cee.tech.events;

import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.Ticket;
import com.cee.tech.app.model.entity.TicketPricing;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;
import com.cee.tech.database.MySqlDatabase;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class AppInit implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("***************** Initializing Database **********************");

        try {
            MySqlDatabase database = MySqlDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//
//        database.getFixtures().add(new Fixture("Kenya Premier League","17:00 EAT", "Nyayo","Gor Mahia", "Shabana","27/10/2023"));
//        database.getFixtures().add(new Fixture("Mozzart Cup","14:00 EAT", "MISC Kasarani","Kariobangi Sharks","Kakamega Homeboyz",  "1/11/2023"));
//
//        database.getTicketPricing().add(new TicketPricing("CAF Champions League", 800, 300));
//
//        database.getBookTicket().add(new Ticket("Mahrez","Mahrez@gmail.com","+254768687334","VIP",1));
//        database.getBookTicket().add(new Ticket("Mahrez","Mahrez@gmail.com","+254768687334","Normal",2));



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
            if(database.getConnection() != null){
                database.getConnection().close();
            }
        } catch (SQLException e) {
            System.out.println("Connection closed");
            throw new RuntimeException(e);
        }


    }
}
