package com.example.api_examen_final_20211c49220231.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ycqtid;

    @Column(name = "ycqtmonth",  nullable = false)
    private String ycqtmonth;
    @Column(name = "ycqtyear",  nullable = false)
    private String ycqtyear;
    @Column(name = "ycqtamount",  nullable = false)
    private Double ycqtamount;
    @Column(name = "ycsqtstatus",  nullable = false)
    private boolean ycsqtstatus;

    @ManyToOne
    @JoinColumn(name = "ycqtid_member")
    private Member ycqtmember;


    public Payment() {
    }

    public Payment(Long ycqtid, String ycqtmonth, String ycqtyear, Double ycqtamount, boolean ycsqtstatus, Member ycqtmember) {
        this.ycqtid = ycqtid;
        this.ycqtmonth = ycqtmonth;
        this.ycqtyear = ycqtyear;
        this.ycqtamount = ycqtamount;
        this.ycsqtstatus = ycsqtstatus;
        this.ycqtmember = ycqtmember;
    }

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

    public Member getYcqtmember() {
        return ycqtmember;
    }

    public void setYcqtmember(Member ycqtmember) {
        this.ycqtmember = ycqtmember;
    }
}
