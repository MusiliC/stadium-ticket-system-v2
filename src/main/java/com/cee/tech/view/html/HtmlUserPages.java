package com.cee.tech.view.html;

import java.io.Serializable;

public class HtmlUserPages implements Serializable {

    public static String homePage(){

        return " <div class=\"mainContainer\">\n" +
                "      <div class=\"heroSection\">\n" +
                "        <div class=\"sectionTitle\">\n" +
                "          <p>\n" +
                "            Experience The <br />\n" +
                "            <span class=\"blueText\">Thrill of Live Sports </span> <br />\n" +
                "            Like Never Before\n" +
                "          </p>\n" +
                "        </div>\n" +
                "        <div>\n" +
                "          <p class=\"summary\">\n" +
                "            Experience the ultimate in live entertainment with our seamless\n" +
                "            ticketing system. Get ready to secure your spot at the heart of the\n" +
                "            action\n" +
                "          </p>\n" +
                "        </div>\n" +
                "        <div class=\"homeButtons\">\n" +
                "            <a href=\"./tickets\" class=\"homeOutlineButton\" >  My Tickets</a>\n" +
                "            <a href=\"./fixtures\" class=\"homeNormalButton\">Upcoming Fixtures</a>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "      <div class=\"heroImage\">\n" +
                "        <div class=\"imageContainer\">\n" +
                "          <img class=\"bgImage\" src=\"https://images.unsplash.com/photo-1522778526097-ce0a22ceb253?auto=format&fit=crop&q=80&w=1470&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D\" alt=\"stadium\">\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>";
    };

    public static String titleHeader(String titlePage){
        return "    <div class=\"mainFixtureContainer\">\n" +
                "      <!-- top part -->\n" +
                "      <div class=\"topPart\">\n" +
                "        <div class=\"topPartTitle\">\n" +
                "<p>" +
               titlePage +
                "</p>" +
                "        </div>\n" +
                "      </div>\n" +
                "      <!-- bottom part  -->\n" +
                "      <div class=\"fixtureContainer\">\n" +
                "        <!-- each fixture div -->\n";
    }

    public static String titleClosingTags(){
        return "</div>\n" +
                "</div>";
    }

    public static String bookTicketPage(String bookTicketForm){
        return "<div class=\"mainTicketBookContainer\"> \n" +
                bookTicketForm +
                "</div>";
    }

    public static String myTicketsPage(){
        return "<div class=\"topTicketPart\">\n" +
                "        <div class=\"topTicketPartTitle\">\n" +
                "          <p>My Tickets</p>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    <div class=\"mainTicketContainer\">\n" +
                "      \n" +
                "        <div class=\"fixtureCard\">\n" +
                "            <div>\n" +
                "                <img width=\"50\" height=\"50\" src=\"https://img.icons8.com/ios-filled/50/football2--v1.png\" alt=\"football2--v1\"/>\n" +
                "            </div>\n" +
                "            <div class=\"ticketInfoDetails\">\n" +
                "                <p class=\"kpl\">Kenya Premier League</p>      \n" +
                "                <p class=\"game\">Gor Mahia vs Afc Leopards</p>\n" +
                "                <p>MISC Kasarani</p>\n" +
                "              </div>  \n" +
                "           <div>\n" +
                "            <p>Ticket Number: 1001</p>\n" +
                "           </div>  \n" +
                "           <div>\n" +
                "            <div class=\"myTicketNormalButton\">\n" +
                "                <a href=\"./ticketdetails\">Ticket Details</a> \n" +
                "            </div>\n" +
                "           </div>          \n" +
                "        </div>\n" +
                "        <div class=\"fixtureCard\">\n" +
                "            <div>\n" +
                "                <img width=\"50\" height=\"50\" src=\"https://img.icons8.com/ios-filled/50/football2--v1.png\" alt=\"football2--v1\"/>\n" +
                "            </div>\n" +
                "            <div class=\"ticketInfoDetails\">\n" +
                "                <p class=\"kpl\">Mozzart Cup</p>      \n" +
                "                <p class=\"game\">Gor Mahia vs Afc Leopards</p>\n" +
                "                <p>Nyayo stadium</p>\n" +
                "              </div>  \n" +
                "           <div>\n" +
                "            <p>Ticket Number: 1001</p>\n" +
                "           </div>  \n" +
                "           <div>\n" +
                "            <div class=\"myTicketNormalButton\">\n" +
                "                <a href=\"./ticketdetails\">Ticket Details</a> \n" +
                "            </div>\n" +
                "           </div>          \n" +
                "        </div>\n" +
                "    </div>";
    }

    public static String ticketDetailsPage(){
        return  " <div class=\"ticketBodyContainer\">\n" +
                "      <div class=\"ticketDetailsTitle\">\n" +
                "        <p>Ticket Details</p>\n" +
                "      </div>\n" +
                "      <div class=\"mainOneTicketContainer\">\n" +
                "        <div class=\"oneTicketTop\">\n" +
                "          <div class=\"topOneTicketPart\">\n" +
                "            <div class=\"imagePart\">\n" +
                "              <img\n" +
                "                src=\"https://footballkenya.org/wp-content/uploads/2019/09/FKF-Website-Header-Logo-300x120.png\"\n" +
                "                alt=\"Logo\"\n" +
                "              />\n" +
                "            </div>\n" +
                "          </div>\n" +
                "          <div class=\"bottomTicketPart\">\n" +
                "            <div class=\"gameStyling\">\n" +
                "              <div class=\"fixtureType\">\n" +
                "                <p class=\"kpl\">Kenya Premier League</p>\n" +
                "                <p class=\"game\">Gor Mahia vs Afc Leopards</p>\n" +
                "                <p class=\"date\">3/11/2023</p>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <div class=\"fineTicketDetails\">\n" +
                "              <div class=\"leftPart\">\n" +
                "                <div class=\"ticketType\">\n" +
                "                  <p>Type: VIP</p>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"amount\">\n" +
                "                  <p>Amount: 500</p>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "              <div class=\"rightPart\">\n" +
                "                <div class=\"ticketNumber\">\n" +
                "                  <p>Ticket Number: 1001</p>\n" +
                "                </div>\n" +
                "                <div class=\"kickOff\">\n" +
                "                  <p>Kick Off: 1300 hrs</p>\n" +
                "                </div>\n" +
                "                <div class=\"location\">\n" +
                "                  <p>Location: Kasarani</p>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "      <div class=\"ticketButtons\">\n" +
                "        <a href=\"./tickets\" class=\"ticketNormalButton\">Back</a>\n" +
                "        <a href=\"#\" class=\"ticketOutlineButton\">Download</a>\n" +
                "      </div>\n" +
                "    </div>";
    }
}
