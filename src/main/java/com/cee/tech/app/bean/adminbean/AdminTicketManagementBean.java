package com.cee.tech.app.bean.adminbean;

import com.cee.tech.app.bean.GenericBeanImpl;
import com.cee.tech.app.model.entity.TicketManagement;
import com.cee.tech.database.Database;

import java.io.Serializable;
import java.util.List;

public class AdminTicketManagementBean extends GenericBeanImpl<TicketManagement> implements AdminTicketManagementI, Serializable {
    public String ticketPricesData() {
        List<TicketManagement> ticketPricings = Database.getDbInstance().getTicketManagement();

        StringBuilder tbBuilder = new StringBuilder();
        tbBuilder.append("<table>");
        tbBuilder.append("<tr>");
        tbBuilder.append(" <th>Ticket Type</th>\n" +
                "            <th>VIP Amount</th>\n" +
                "            <th>Normal Amount</th>\n" +
                "            <th>Action</th>");
        tbBuilder.append("</tr>");

        for (TicketManagement ticketPricing: ticketPricings){
            tbBuilder.append(ticketPricing.ticketPricingTableRow());
        }
        tbBuilder.append("</table>");
        return tbBuilder.toString();
    }

    public TicketManagement addUpdateTicketPrice(TicketManagement ticketPricing) throws Exception {
        return null;
    }

    public void deleteFixture(TicketManagement ticketPricing) {
        System.out.println("Delete fixture");
    }
}
