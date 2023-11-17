package com.cee.tech.usebean;

import java.io.Serializable;

public class FooterBean implements Serializable {
    private String footerMenu;

    public String getFooterMenu() {
        return footerMenu;
    }

    public void setFooterMenu(String footerMenu) {
        this.footerMenu = footerMenu;
    }

    public void  generateFooterMenu(){
        this.footerMenu = "  <footer class=\"footerContainer\">\n" +
                "     \n" +
                "        <div class=\"rightsClass\">\n" +
                "            <a href=\"https://musili-c.vercel.app/\"  target=\"_blank\" rel=\"noopener noreferrer\">@2023 Brian Musili</a>\n" +
                "            <p>All rights reserved</p>\n" +
                "          \n" +
                "        </div>\n" +
                "    </footer>";
    }
}
