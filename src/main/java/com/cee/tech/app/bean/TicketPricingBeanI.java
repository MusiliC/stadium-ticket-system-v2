package com.cee.tech.app.bean;

import com.cee.tech.app.model.entity.TicketPricing;

public interface TicketPricingBeanI {
    public  String ticketPricesData();
    public TicketPricing addUpdateTicketPrice(TicketPricing ticketPricing) throws  Exception;
    public  void deleteFixture(TicketPricing ticketPricing);
}
