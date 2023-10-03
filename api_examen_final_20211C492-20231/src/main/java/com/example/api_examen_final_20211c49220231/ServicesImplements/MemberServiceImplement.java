package com.example.api_examen_final_20211c49220231.ServicesImplements;

import com.example.api_examen_final_20211c49220231.Entities.Member;
import com.example.api_examen_final_20211c49220231.Repository.MemberRepository;
import com.example.api_examen_final_20211c49220231.ServicesInterfaces.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImplement implements IMemberService {
    @Autowired
    private MemberRepository ycqtR;
    @Override
    public void insert(Member ycqtmember) {
        ycqtR.save(ycqtmember);
    }

    @Override
    public List<Member> list() {
        return ycqtR.findAll();
    }
}
