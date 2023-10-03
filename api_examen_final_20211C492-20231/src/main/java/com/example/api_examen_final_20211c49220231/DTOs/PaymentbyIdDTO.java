package com.example.api_examen_final_20211c49220231.DTOs;

import com.example.api_examen_final_20211c49220231.Entities.Member;

public class PaymentbyIdDTO {

    private Long ycqtid;
    private String ycqtmonth;
    private String ycqtyear;
    private Double ycqtamount;
    private boolean ycsqtstatus;

    public Long getYcqtid() {
        return ycqtid;
    }

    public void setYcqtid(Long ycqtid) {
        this.ycqtid = ycqtid;
    }

    public String getYcqtmonth() {
        return ycqtmonth;
    }

    public void setYcqtmonth(String ycqtmonth) {
        this.ycqtmonth = ycqtmonth;
    }

    public String getYcqtyear() {
        return ycqtyear;
    }

    public void setYcqtyear(String ycqtyear) {
        this.ycqtyear = ycqtyear;
    }

    public Double getYcqtamount() {
        return ycqtamount;
    }

    public void setYcqtamount(Double ycqtamount) {
        this.ycqtamount = ycqtamount;
    }

    public boolean isYcsqtstatus() {
        return ycsqtstatus;
    }

    public void setYcsqtstatus(boolean ycsqtstatus) {
        this.ycsqtstatus = ycsqtstatus;
    }
}
