package com.cee.tech.events;

import com.cee.tech.app.model.entity.Fixture;
import com.cee.tech.app.model.entity.Ticket;
import com.cee.tech.app.model.entity.TicketPricing;
import com.cee.tech.app.model.entity.User;
import com.cee.tech.database.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInit implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("***************** Initializing Database **********************");

        Database database = Database.getDbInstance();
        database.getUsers().add(new User("1", "Musili", "Musili123", 1, 1));
        database.getUsers().add(new User("2", "Cee", "Cee123", 2,0));
        database.getUsers().add(new User("3", "Mahrez", "Mahrez123", 1,0));
        database.getUsers().add(new User("4", "Admin", "Admin123"));

        database.getFixtures().add(new Fixture("Kenya Premier League","17:00 EAT", "Nyayo","Gor Mahia", "Shabana","27/10/2023"));
        database.getFixtures().add(new Fixture("Mozzart Cup","14:00 EAT", "MISC Kasarani","Kariobangi Sharks","Kakamega Homeboyz",  "1/11/2023"));

        database.getTicketPricing().add(new TicketPricing("CAF Champions League", 800, 300));

        database.getBookTicket().add(new Ticket("Mahrez","Mahrez@gmail.com","+254768687334","VIP",1));
        database.getBookTicket().add(new Ticket("Mahrez","Mahrez@gmail.com","+254768687334","Normal",2));


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println();
        System.out.println();
        System.out.println("**************App killed*****************");
        System.out.println();
        System.out.println();
    }
}
