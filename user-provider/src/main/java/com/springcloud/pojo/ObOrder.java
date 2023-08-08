package com.springcloud.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ob_order")
public class ObOrder {
    @Column(name = "WAYBILL_NO")
    private String waybillNo;

    @Column(name = "BIG_TYPE")
    private String bigType;

    @Column(name = "DTORDER_DATE")
    private Date dtorderDate;

    /**
     * @return WAYBILL_NO
     */
    public String getWaybillNo() {
        return waybillNo;
    }

    /**
     * @param waybillNo
     */
    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    /**
     * @return BIG_TYPE
     */
    public String getBigType() {
        return bigType;
    }

    /**
     * @param bigType
     */
    public void setBigType(String bigType) {
        this.bigType = bigType;
    }

    /**
     * @return DTORDER_DATE
     */
    public Date getDtorderDate() {
        return dtorderDate;
    }

    /**
     * @param dtorderDate
     */
    public void setDtorderDate(Date dtorderDate) {
        this.dtorderDate = dtorderDate;
    }
}