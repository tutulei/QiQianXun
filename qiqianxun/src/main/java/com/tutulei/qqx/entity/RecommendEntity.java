package com.tutulei.qqx.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "recommend", schema = "Qiqianxun", catalog = "")
public class RecommendEntity {
    private int recommendId;
    private Integer recommendUser;
    private Integer recommendAcupoint;
    private Timestamp recommendCtime;

    @Id
    @Column(name = "recommend_id")
    public int getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(int recommendId) {
        this.recommendId = recommendId;
    }

    @Basic
    @Column(name = "recommend_user")
    public Integer getRecommendUser() {
        return recommendUser;
    }

    public void setRecommendUser(Integer recommendUser) {
        this.recommendUser = recommendUser;
    }

    @Basic
    @Column(name = "recommend_acupoint")
    public Integer getRecommendAcupoint() {
        return recommendAcupoint;
    }

    public void setRecommendAcupoint(Integer recommendAcupoint) {
        this.recommendAcupoint = recommendAcupoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecommendEntity that = (RecommendEntity) o;
        return recommendId == that.recommendId &&
                Objects.equals(recommendUser, that.recommendUser) &&
                Objects.equals(recommendAcupoint, that.recommendAcupoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recommendId, recommendUser, recommendAcupoint);
    }

    @Basic
    @Column(name = "recommend_ctime")
    public Timestamp getRecommendCtime() {
        return recommendCtime;
    }

    public void setRecommendCtime(Timestamp recommendCtime) {
        this.recommendCtime = recommendCtime;
    }
}
