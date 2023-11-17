package com.cee.tech.app.bean.adminbean;

import com.cee.tech.app.bean.TicketPricingBeanI;
import com.cee.tech.app.model.entity.TicketPricing;
import com.cee.tech.database.Database;

import java.io.Serializable;
import java.util.List;

public class TicketPricingBean implements TicketPricingBeanI, Serializable {
    @Override
    public String ticketPricesData() {
        List<TicketPricing> ticketPricings = Database.getDbInstance().getTicketPricing();

        StringBuilder tbBuilder = new StringBuilder();
        tbBuilder.append("<table>");
        tbBuilder.append("<tr>");
        tbBuilder.append(" <th>Ticket Type</th>\n" +
                "            <th>VIP Amount</th>\n" +
                "            <th>Normal Amount</th>\n" +
                "            <th>Action</th>");
        tbBuilder.append("</tr>");

        for (TicketPricing ticketPricing: ticketPricings){
            tbBuilder.append(ticketPricing.ticketPricingTableRow());
        }
        tbBuilder.append("</table>");
        return tbBuilder.toString();
    }

    @Override
    public TicketPricing addUpdateTicketPrice(TicketPricing ticketPricing) throws Exception {
        return null;
    }

    @Override
    public void deleteFixture(TicketPricing ticketPricing) {
        System.out.println("Delete fixture");
    }
}
