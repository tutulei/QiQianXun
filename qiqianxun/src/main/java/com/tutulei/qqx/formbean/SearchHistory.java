package com.tutulei.qqx.formbean;

import java.sql.Timestamp;

public class SearchHistory {
    private Integer shistoryUser;
    private String shistoryContent;
    private Timestamp shistoryCtime;

    public Integer getShistoryUser() {
        return shistoryUser;
    }

    public void setShistoryUser(Integer shistoryUser) {
        this.shistoryUser = shistoryUser;
    }

    public String getShistoryContent() {
        return shistoryContent;
    }

    public void setShistoryContent(String shistoryContent) {
        this.shistoryContent = shistoryContent;
    }

    public Timestamp getShistoryCtime() {
        return shistoryCtime;
    }

    public void setShistoryCtime(Timestamp shistoryCtime) {
        this.shistoryCtime = shistoryCtime;
    }
}
