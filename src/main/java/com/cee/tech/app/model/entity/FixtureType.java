package com.cee.tech.app.model.entity;

import java.io.Serializable;

public enum FixtureType implements Serializable {
    KENYA_PREMIER_LEAGUE("Kenya Premier League"),
    MOZZART_CUP("Mozzart Cup"),
    CAF_CHAMPIONS_LEAGUE("CAF Champions League"),
    CAF_CONFEDERATION("CAF Confederation"),
    AFCON("AFCON");
    private String name;

    FixtureType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
