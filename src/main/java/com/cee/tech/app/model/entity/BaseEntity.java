package com.cee.tech.app.model.entity;

import com.cee.tech.database.helper.DBTableId;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.EticketTableColHeader;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {
//    @EticketTableColHeader(headerLabel = "id")
//    @DBTableId
//    @DbTableColumn(name = "id", definition = "int", primaryKey = "primary key", notNull = "not null")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
