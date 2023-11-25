package com.cee.tech.view.toolbar;

import java.io.Serializable;

public class MenuLink implements Serializable {
    private String label;
    private String url;

    public MenuLink(String label, String url) {
        this.label = label;
        this.url = url;
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
}
