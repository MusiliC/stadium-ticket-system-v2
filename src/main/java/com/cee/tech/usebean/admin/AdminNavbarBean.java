package com.cee.tech.usebean.admin;

import java.io.Serializable;

public class AdminNavbarBean implements Serializable {
    private String adminMenu;

    public String getAdminMenu() {
        return adminMenu;
    }

    public void setAdminMenu(String adminMenu) {
        this.adminMenu = adminMenu;
    }

    public void generateAdminMenu(String firstLetter){

        adminMenu = "<div class=\"topAdminPart\" >\n" +
                "            <div class=\"\">\n" +
                "                <a href=\"./fixtures\">FIXTURES</a>\n" +
                "            </div>\n" +
                " <div class=\"\">\n" +
                "          <p class=\"profile\" >  " +
                firstLetter +
                "</p>\n" +
                "        </div>" +
                " <div class=\"adminLogout\">\n" +
                "            <a href=\"./admin/logout\" class=\"\"> LOGOUT </a>\n" +
                "        </div>" +
                "    </div>";

    }
}
