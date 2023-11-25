package com.cee.tech.view.toolbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Navbar implements Menu, Serializable {

    private final List<MenuLink> menuLinks = new ArrayList<>();

    {
        menuLinks.add(new MenuLink("HOME", "./home"));
        menuLinks.add(new MenuLink("TICKETS", "./tickets"));
        menuLinks.add(new MenuLink("FIXTURES", "./fixtures"));
    }

    @Override
    public String menu(String firstLetter) {
       String navbar;
        navbar = "  <div class=\"navbarContainer\" >\n" +
                "        <nav class=\"navClass\">\n" +
                "            <div class=\"title\">\n" +
                "                <a href=\"./home\">Etciket</a>\n" +
                "            </div>\n";

        navbar += "div class=\"links\" >\n";
        for (MenuLink link: menuLinks){
            navbar += "<a "  + " href=\"" + link.getUrl() + "\">" + link.getLabel() + "</a>";
        }

        navbar += " </div>";

        navbar +=  " <div class=\"lastPart\">\n" +
                "<p class=\"profile\" >  " +
                firstLetter +
                "</p>\n" +
                "          <a href=\"./logout\" class=\"contactButton\"> LOGOUT </a>\n" +
                "        </div>" +
                "        </nav>\n" +
                "    </div>";


        return navbar;
    }
}
