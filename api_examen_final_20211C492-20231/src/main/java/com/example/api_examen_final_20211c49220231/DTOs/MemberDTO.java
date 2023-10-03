package com.example.api_examen_final_20211c49220231.DTOs;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MemberDTO {

    private Long ycqtid;
    private String ycqtname;
    private Long ycqtmember_code;

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
