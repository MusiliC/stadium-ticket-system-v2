package com.cee.tech.usebean.admin;

import java.io.Serializable;

public class AdminMenuModel implements Serializable {

    private String label;
    private String url;
    private String icon;

    public AdminMenuModel(String label, String url, String icon) {
        this.label = label;
        this.url = url;
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
