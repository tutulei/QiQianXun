package com.tutulei.qqx.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "history", schema = "Qiqianxun", catalog = "")
public class HistoryEntity {
    private int historyId;
    private Integer historyUser;
    private Integer historyKey;
    private Timestamp historyCtime;

    @Id
    @Column(name = "history_id")
    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    @Basic
    @Column(name = "history_user")
    public Integer getHistoryUser() {
        return historyUser;
    }

    public void setHistoryUser(Integer historyUser) {
        this.historyUser = historyUser;
    }

    @Basic
    @Column(name = "history_key")
    public Integer getHistoryKey() {
        return historyKey;
    }

    public void setHistoryKey(Integer historyKey) {
        this.historyKey = historyKey;
    }

    @Basic
    @Column(name = "history_ctime")
    public Timestamp getHistoryCtime() {
        return historyCtime;
    }

    public void setHistoryCtime(Timestamp historyCtime) {
        this.historyCtime = historyCtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryEntity that = (HistoryEntity) o;
        return historyId == that.historyId &&
                Objects.equals(historyUser, that.historyUser) &&
                Objects.equals(historyKey, that.historyKey) &&
                Objects.equals(historyCtime, that.historyCtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historyId, historyUser, historyKey, historyCtime);
    }
}
