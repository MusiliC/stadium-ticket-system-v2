package com.cee.tech.view.html;

import java.io.Serializable;

public class HtmlUserPages implements Serializable {

    public static  String registerUser(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>Login</title>\n" +
                "\n" +
                "    <style>\n" +
                "      body {\n" +
                "        font-family: Arial, sans-serif;\n" +
                "        text-align: center;\n" +
                "        height:90vh;\n" +
                "        display: flex;\n" +
                "        align-items: center;\n" +
                "        justify-content: center;" +
                "      }\n" +
                "\n" +
                "      .login-container {\n" +
                "        background-color: #fff;\n" +
                "        width: 400px;\n" +
                "        margin: 50px auto;\n" +
                "        padding: 20px;\n" +
                "        border-radius: 5px;\n" +
                "        box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);\n" +
                "      }\n" +
                "\n" +
                "      h2 {\n" +
                "        color: rgb(1, 69, 171);\n" +
                "      }\n" +
                "\n" +
                "      form {\n" +
                "        text-align: left;\n" +
                "      }\n" +
                "\n" +
                "      input[type=\"text\"],\n" +
                "      input[type=\"password\"] {\n" +
                "        width: 95%;\n" +
                "        padding: 10px;\n" +
                "        margin: 10px 0;\n" +
                "        border: 1px solid #ccc;\n" +
                "        border-radius: 5px;\n" +
                "        background-color: rgb(232,240,254);\n" +
                "      }\n" +
                "\n" +
                "      input[type=\"text\"]:focus,\n" +
                "      input[type=\"password\"]:focus {\n" +
                "        border-color: rgb(238, 238, 238);\n" +
                "        outline: none;\n" +
                "      }\n" +
                "\n" +
                "      input[type=\"submit\"] {\n" +
                "        background-color: rgb(0, 53, 133);\n" +
                "        color: #fff;\n" +
                "        padding: 10px 20px;\n" +
                "        border: none;\n" +
                "        border-radius: 10px;\n" +
                "        cursor: pointer;\n" +
                "      }\n" +
                ".regLink{\n" +
                "         display: flex;\n" +
                "         align-items: center;\n" +
                "          justify-content: space-between;\n" +
                "          padding: 15px 0px;\n" +
                "        }\n" +
                "      .regLink a{\n" +
                "        text-decoration: none;\n" +
                "        color: rgb(10, 79, 182);\n" +
                "        font-weight: 600;\n" +
                "    }" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div class=\"login-container\">\n" +

                "<h3>Register User</h3>\n" +
                "      <form action=\"./user\" method=\"post\">\n" +
                "        <label for=\"username\">Username:</label>\n" +
                "        <input type=\"text\"  name=\"username\" required />\n" +
                "\n" +
                "        <label for=\"password\">Password:</label>\n" +
                "        <input type=\"password\" name=\"password\" required>\n" +
                "\n" +
                "        <label >Confirm Password:</label>\n" +
                "        <input type=\"password\" name=\"confirmPassword\" required>\n" +
                "\n" +
                "        <div class=\"regLink\">\n" +
                "            <input type=\"submit\"/>\n" +
                "            <div> <a href=\"./\">Back to login</a></div>\n" +
                "        </div>" +

                "      </form>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "</html>\n";
    }

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
