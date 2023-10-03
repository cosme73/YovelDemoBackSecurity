package com.example.api_examen_final_20211c49220231.ServicesInterfaces;

import com.example.api_examen_final_20211c49220231.Entities.Member;

import java.util.List;

public interface IMemberService {
    public void insert(Member ycqtmember);
    public List<Member> list();

}
