package com.cee.tech.app.model.entity;

import com.cee.tech.database.helper.DbTable;
import com.cee.tech.database.helper.DbTableColumn;
import com.cee.tech.view.html.EticketFormField;

@DbTable(name = "audit")
public class Audit extends BaseEntity{

    @DbTableColumn(name = "logdetails", notNull = "not null", definition = "longtext")
    private String logdetails;

    public String getLogdetails() {
        return logdetails;
    }

    public void setLogdetails(String logdetails) {
        this.logdetails = logdetails;
    }
}
