package com.example.api_examen_final_20211c49220231.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"ycqtuser_id", "ycqtrol"})})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ycqtid;

    private String ycqtrol;

    @ManyToOne
    @JoinColumn(name = "ycqtuser_id", nullable = false)
    private Users ycqtuser;

    public Role() {
    }

    public Role(Long ycqtid, String ycqtrol, Users ycqtuser) {
        this.ycqtid = ycqtid;
        this.ycqtrol = ycqtrol;
        this.ycqtuser = ycqtuser;
    }

    public Long getYcqtid() {
        return ycqtid;
    }

    public void setYcqtid(Long ycqtid) {
        this.ycqtid = ycqtid;
    }

    public String getYcqtrol() {
        return ycqtrol;
    }

    public void setYcqtrol(String ycqtrol) {
        this.ycqtrol = ycqtrol;
    }

    public Users getYcqtuser() {
        return ycqtuser;
    }

    public void setYcqtuser(Users ycqtuser) {
        this.ycqtuser = ycqtuser;
    }
}
