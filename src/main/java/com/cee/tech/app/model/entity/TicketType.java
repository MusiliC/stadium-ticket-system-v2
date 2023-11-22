package com.cee.tech.app.model.entity;

import java.io.Serializable;

public enum TicketType implements Serializable {
    VIP("VIP"),
    NORMAL("Normal");

    private String name;

    TicketType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
