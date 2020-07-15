package com.tutulei.qqx.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "acupoint", schema = "Qiqianxun", catalog = "")
public class AcupointEntity {
    private int acupointId;
    private String acupointName;
    private String acupointFunction;
    private String acupointLocation;
    private String acupointPic;
    private String acupointDissection;
    private String acupointOperate;
    private String acupointMeridian;
    private String acupointPic2;

    @Id
    @Column(name = "acupoint_id")
    public int getAcupointId() {
        return acupointId;
    }

    public void setAcupointId(int acupointId) {
        this.acupointId = acupointId;
    }

    @Basic
    @Column(name = "acupoint_name")
    public String getAcupointName() {
        return acupointName;
    }

    public void setAcupointName(String acupointName) {
        this.acupointName = acupointName;
    }

    @Basic
    @Column(name = "acupoint_function")
    public String getAcupointFunction() {
        return acupointFunction;
    }

    public void setAcupointFunction(String acupointFunction) {
        this.acupointFunction = acupointFunction;
    }

    @Basic
    @Column(name = "acupoint_location")
    public String getAcupointLocation() {
        return acupointLocation;
    }

    public void setAcupointLocation(String acupointLocation) {
        this.acupointLocation = acupointLocation;
    }

    @Basic
    @Column(name = "acupoint_pic")
    public String getAcupointPic() {
        return acupointPic;
    }

    public void setAcupointPic(String acupointPic) {
        this.acupointPic = acupointPic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcupointEntity that = (AcupointEntity) o;
        return acupointId == that.acupointId &&
                Objects.equals(acupointName, that.acupointName) &&
                Objects.equals(acupointFunction, that.acupointFunction) &&
                Objects.equals(acupointLocation, that.acupointLocation) &&
                Objects.equals(acupointPic, that.acupointPic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acupointId, acupointName, acupointFunction, acupointLocation, acupointPic);
    }

    @Basic
    @Column(name = "acupoint_dissection")
    public String getAcupointDissection() {
        return acupointDissection;
    }

    public void setAcupointDissection(String acupointDissection) {
        this.acupointDissection = acupointDissection;
    }

    @Basic
    @Column(name = "acupoint_operate")
    public String getAcupointOperate() {
        return acupointOperate;
    }

    public void setAcupointOperate(String acupointOperate) {
        this.acupointOperate = acupointOperate;
    }

    @Basic
    @Column(name = "acupoint_meridian")
    public String getAcupointMeridian() {
        return acupointMeridian;
    }

    public void setAcupointMeridian(String acupointMeridian) {
        this.acupointMeridian = acupointMeridian;
    }

    @Basic
    @Column(name = "acupoint_pic2")
    public String getAcupointPic2() {
        return acupointPic2;
    }

    public void setAcupointPic2(String acupointPic2) {
        this.acupointPic2 = acupointPic2;
    }
}
