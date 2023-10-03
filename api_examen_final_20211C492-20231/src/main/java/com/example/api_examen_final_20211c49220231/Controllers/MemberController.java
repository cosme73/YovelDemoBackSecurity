package com.example.api_examen_final_20211c49220231.Controllers;

import com.example.api_examen_final_20211c49220231.DTOs.MemberDTO;
import com.example.api_examen_final_20211c49220231.Entities.Member;
import com.example.api_examen_final_20211c49220231.ServicesInterfaces.IMemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    private  IMemberService ycqtmS;
    //HUR01: Como administrador quiero registrar un integrante del club para
    //gestionarlos.
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody MemberDTO ycqtdto) {
        ModelMapper ycqtm = new ModelMapper();
        Member ycqtd = ycqtm.map(ycqtdto, Member.class);
        ycqtmS.insert(ycqtd);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<MemberDTO> lista() {
        return ycqtmS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, MemberDTO.class);
        }).collect(Collectors.toList());

    }
}
