package com.tutulei.qqx.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "shistory", schema = "Qiqianxun", catalog = "")
public class ShistoryEntity {
    private int shistoryId;
    private Integer shistoryUser;
    private String shistoryContent;
    private Timestamp shistoryCtime;

    @Id
    @Column(name = "shistory_id")
    public int getShistoryId() {
        return shistoryId;
    }

    public void setShistoryId(int shistoryId) {
        this.shistoryId = shistoryId;
    }

    @Basic
    @Column(name = "shistory_user")
    public Integer getShistoryUser() {
        return shistoryUser;
    }

    public void setShistoryUser(Integer shistoryUser) {
        this.shistoryUser = shistoryUser;
    }

    @Basic
    @Column(name = "shistory_content")
    public String getShistoryContent() {
        return shistoryContent;
    }

    public void setShistoryContent(String shistoryContent) {
        this.shistoryContent = shistoryContent;
    }

    @Basic
    @Column(name = "shistory_ctime")
    public Timestamp getShistoryCtime() {
        return shistoryCtime;
    }

    public void setShistoryCtime(Timestamp shistoryCtime) {
        this.shistoryCtime = shistoryCtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShistoryEntity that = (ShistoryEntity) o;
        return shistoryId == that.shistoryId &&
                Objects.equals(shistoryUser, that.shistoryUser) &&
                Objects.equals(shistoryContent, that.shistoryContent) &&
                Objects.equals(shistoryCtime, that.shistoryCtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shistoryId, shistoryUser, shistoryContent, shistoryCtime);
    }
}
