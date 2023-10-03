package com.example.api_examen_final_20211c49220231.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ycqtid;


    @Column(name = "ycqtname",   nullable = false, length = 50)
    private String ycqtname;

    @Column(name = "ycqtmember_code",  nullable = false)
    private Long ycqtmember_code;

    public Member() {
    }

    public Member(Long ycqtid, String ycqtname, Long ycqtmember_code) {
        this.ycqtid = ycqtid;
        this.ycqtname = ycqtname;
        this.ycqtmember_code = ycqtmember_code;
    }

    public Long getYcqtid() {
        return ycqtid;
    }

    public void setYcqtid(Long ycqtid) {
        this.ycqtid = ycqtid;
    }

    public String getYcqtname() {
        return ycqtname;
    }

    public void setYcqtname(String ycqtname) {
        this.ycqtname = ycqtname;
    }

    public Long getYcqtmember_code() {
        return ycqtmember_code;
    }

    public void setYcqtmember_code(Long ycqtmember_code) {
        this.ycqtmember_code = ycqtmember_code;
    }
}
