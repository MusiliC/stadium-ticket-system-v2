package com.cee.tech.app.model.entity;

import com.cee.tech.database.helper.DBTableId;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.EticketTableColHeader;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    @EticketTableColHeader(headerLabel = "id")
    @DBTableId
    @DbTableColumn(name = "id", definition = "int", primaryKey = "primary key", notNull = "not null")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
