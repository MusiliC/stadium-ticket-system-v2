package com.cee.tech.usebean.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SidebarBean implements Serializable {
    private String sidebarMenu;

    public String getSidebarMenu() {
        return sidebarMenu;
    }

    public void setSidebarMenu(String sidebarMenu) {
        this.sidebarMenu = sidebarMenu;
    }

//    private final List<AdminMenuModel> adminMenuLinks = new ArrayList<>();
//
//    {
//        adminMenuLinks.add(new AdminMenuModel("Create Fixture", "./admin", "https://img.icons8.com/ios/50/000000/edit--v1.png"));
//        adminMenuLinks.add(new AdminMenuModel("Upcoming Fixtures", "./adminfixtures", "https://img.icons8.com/ios/50/football.png"));
//        adminMenuLinks.add(new AdminMenuModel("Ticket Management", "./adminticket", "https://img.icons8.com/dotty/80/ticket.png"));
//        adminMenuLinks.add(new AdminMenuModel("Ticket Management List", "./adminticketpricing", "https://img.icons8.com/ios/50/us-dollar-circled--v1.png"));
//        adminMenuLinks.add(new AdminMenuModel("Ticket Report", "./adminticketreport", "https://img.icons8.com/ios/50/graph-report.png"));
//        adminMenuLinks.add(new AdminMenuModel("User Report", "./adminusers", "https://img.icons8.com/ios-glyphs/30/group.png"));
//
//    }

    public void generateSidebar() {
        sidebarMenu = "    <div class=\"sidebar\">\n" +
                "            <div class=\"adminAppName\">\n" +
                "                <div>\n" +
                "                    <img width=\"25\" height=\"25\" src=\"https://img.icons8.com/ios-filled/50/football2--v1.png\" alt=\"football2--v1\" style=\"filter: invert(100%);\"/>\n" +
                "                </div>\n" +
                "                <p>Eticket</p>\n" +
                "            </div>\n" +
                "            <div class=\"adminTitle\">\n" +
                "                <img width=\"23\" height=\"23\" src=\"https://img.icons8.com/ios/50/performance-macbook.png\" alt=\"performance-macbook\" style=\"filter: invert(100%);\"/>\n" +
                "                <p>Dashboard</p>\n" +
                "            </div>\n" +
                "            <div class=\"adminLinks\">\n" +
                "                <div class=\"adminLinkTag\">\n" +
                "                    <img width=\"22\" height=\"22\" src=\"https://img.icons8.com/ios/50/000000/edit--v1.png\" alt=\"edit--v1\" style=\"filter: invert(100%);\"/>\n" +
                "                    <div>\n" +
                "                    <a href=\"./admin\">Create Fixture</a>\n" +
                "                </div>\n" +
                "                </div>\n" +
                "   <div class=\"adminLinkTag\">\n" +
                "            <img\n" +
                "              width=\"22\"\n" +
                "              height=\"22\"\n" +
                "              src=\"https://img.icons8.com/ios/50/football.png\"\n" +
                "              alt=\"football\"\n" +
                "              style=\"filter: invert(100%)\"\n" +
                "            />\n" +
                "            <div>\n" +
                "              <a href=\"./adminfixtures\">Upcoming Fixtures</a>\n" +
                "            </div>\n" +
                "          </div>" +

                "  <div class=\"adminLinkTag\">\n" +
                "            <img\n" +
                "              width=\"22\"\n" +
                "              height=\"22\"\n" +
                "              src=\"https://img.icons8.com/dotty/80/ticket.png\"\n" +
                "              alt=\"ticket\"\n" +
                "              style=\"filter: invert(100%)\"\n" +
                "            />\n" +
                "            <div>\n" +
                "              <a href=\"./adminticket\">Ticket Management</a>\n" +
                "            </div>\n" +
                "          </div>" +
                "     <div class=\"adminLinkTag\">\n" +
                "            <img\n" +
                "              width=\"22\"\n" +
                "              height=\"22\"\n" +
                "              src=\"https://img.icons8.com/ios/50/us-dollar-circled--v1.png\"\n" +
                "              alt=\"us-dollar-circled--v1\"\n" +
                "              style=\"filter: invert(100%)\"\n" +
                "            />\n" +
                "            <div>\n" +
                "              <a href=\"./adminticketpricing\">Ticket Manage List</a>\n" +
                "            </div>\n" +
                "          </div>" +
                "                <div class=\"adminLinkTag\">\n" +
                "                    <img width=\"22\" height=\"22\" src=\"https://img.icons8.com/ios/50/graph-report.png\" alt=\"graph-report\" style=\"filter: invert(100%);\"/>\n" +
                "                    <div>\n" +
                "                        <a href=\"./adminticketreport\">Ticket Report</a>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"adminLinkTag\">\n" +
                "                    <img width=\"22\" height=\"22\" src=\"https://img.icons8.com/ios-glyphs/30/group.png\" alt=\"group\" style=\"filter: invert(100%);\"/>\n" +
                "                    <div>\n" +
                "                        <a href=\"./adminusers\">Users</a>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "               \n" +
                "              \n" +
                "            </div>\n" +
                "            <div class=\"adminSettings\">\n" +
                "                <div>\n" +
                "                 <img width=\"23\" height=\"23\" src=\"https://img.icons8.com/ios/50/000000/settings--v1.png\" alt=\"settings--v1\"  style=\"filter: invert(100%);\"/>\n" +
                "                </div>\n" +
                "                <p>Settings</p>\n" +
                "            </div>\n" +
                "        </div>";
    }
}