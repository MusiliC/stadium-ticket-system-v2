package com.cee.tech.view.toolbar;

import java.io.Serializable;

public class Navbar implements Menu, Serializable {


    @Override
    public String menu(String firstLetter) {
       String navbar;
        navbar = "  <div class=\"navbarContainer\" >\n" +
                "        <nav class=\"navClass\">\n" +
                "            <div class=\"title\">\n" +
                "                <a href=\"./home\">Etciket</a>\n" +
                "            </div>\n" +
                "            <div class=\"links\" >\n" +
                "               <a href=\"./home\">HOME</a>\n" +
                "               <a href=\"./tickets\">TICKETS</a>\n" +
                "               <a href=\"./fixtures\">FIXTURES</a>\n" +
                "            </div>\n" +
                " <div class=\"lastPart\">\n" +
                "          <p class=\"profile\" >  " +
                firstLetter +
                "</p>\n" +
                "          <a href=\"./logout\" class=\"contactButton\"> LOGOUT </a>\n" +
                "        </div>" +
                "        </nav>\n" +
                "    </div>";


        return navbar;
    }
}
