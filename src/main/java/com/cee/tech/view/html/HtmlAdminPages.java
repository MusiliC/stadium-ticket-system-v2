package com.cee.tech.view.html;


import com.cee.tech.app.model.entity.TicketManagement;
import com.cee.tech.app.model.entity.User;

public class HtmlAdminPages {

    public static String adminHomePage(String adminFixtureForm){
        return " <div class=\"formMainContainer\">\n" +
                "      <div class=\"createFixtureContainer\">\n" +
                "        <p class=\"fixtureTitle\">Create Fixture</p>\n" +
                "\n" +
                adminFixtureForm +
                "      </div>\n" +
                "    </div>";
    }

    public  static String adminCreateTicketManagement(String adminTicketManage){
        return " <div class=\"formMainContainer\">\n" +
                "      <div class=\"createFixtureContainer\">\n" +
                "        <p class=\"fixtureTitle\">Manage Tickets</p>\n" +
                "\n" +
                adminTicketManage +
                "      </div>\n" +
                "    </div>";
    }
    public static String admin(String adminFixtureForm){
        return " <div class=\"formMainContainer\">\n" +
                "      <div class=\"createFixtureContainer\">\n" +
                "        <p class=\"fixtureTitle\">Create Fixture</p>\n" +
                "\n" +
                adminFixtureForm +
                "      </div>\n" +
                "    </div>";
    }

    public static String adminFixturesPage(String adminUpcomingFixtures){
        return "<div class=\"mainFixtureContainer\">\n" +
                "      <!-- top part -->\n" +
                "      <!-- bottom part  -->\n" +
                "      <div class=\"fixtureAdminContainer\">\n" +
                "        <!-- each fixture div -->\n" +
                adminUpcomingFixtures +
                "      </div>\n" +
                "    </div>";
    }

    public static String adminTicketManageListPage(String ticketListPage){
        return "   <div class=\"TicketPricingContainer\">\n" +
                "      <div class=\"createFixtureContainer\">\n" +
                "        <p class=\"fixtureTitle\">Ticket Management List</p>\n" +
                "\n" +
                "        <!-- Ticket table -->\n" +
                "       <div class=\"tablePricing\">\n" +
                ticketListPage +
                "      </div>\n" +
                "  \n" +
                "        </div>\n" +
                "      </div>\n" +
                "\n" +
                "      </div>\n" +
                "    </div>";
    }

    public static String adminFixtureReport(){
        return "    <div class=\"adminTableContainer\">\n" +
                "      <p class=\"fixtureTitleTable\">Ticket Report</p>\n" +
                "      <table>\n" +
                "        <tr>\n" +
                "          <th>Field</th>\n" +
                "          <th>Data</th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Fixture</td>\n" +
                "          <td>Gor vs AFC - 11/11/2023</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Fixture Type</td>\n" +
                "          <td>Kenya Premier League</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Total Allocated Tickets</td>\n" +
                "          <td>1000</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Total Sold</td>\n" +
                "          <td>500</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Not Sold</td>\n" +
                "          <td>500</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Normal Tickets sold</td>\n" +
                "          <td>100</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Normal generated outcome</td>\n" +
                "          <td>10,000</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>VIP Tickets sold</td>\n" +
                "          <td>50</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>vip generated outcome</td>\n" +
                "          <td>7,000</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <td>Total generated outcome</td>\n" +
                "          <td>70,000</td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "      <div class=\"ticketReportButton\">\n" +
                "        <a href=\"#\" class=\"ticketReportOneButton\">Download</a>\n" +
                "      </div>\n" +
                "    </div>";
    }

    public static String adminUserReport(String userReportPage){
        return  "   <div class=\"adminTableContainer\">\n" +
                "      <p class=\"fixtureTitleTable\">Users Report</p>\n" +
                "\n" +
                userReportPage +
                "      <div class=\"ticketReportButton\">\n" +
                "        <a href=\"#\" class=\"ticketReportOneButton\">Download</a>\n" +
                "      </div>\n" +
                "    </div>";
    }
}
