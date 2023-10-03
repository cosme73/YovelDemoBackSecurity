package com.example.api_examen_final_20211c49220231.Controllers;


import com.example.api_examen_final_20211c49220231.DTOs.PaymentDTO;
import com.example.api_examen_final_20211c49220231.DTOs.PaymentbyIdDTO;

import com.example.api_examen_final_20211c49220231.Entities.Member;
import com.example.api_examen_final_20211c49220231.Entities.Payment;
import com.example.api_examen_final_20211c49220231.ServicesInterfaces.IPaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private IPaymentService ycqtpS;
    //HUR01: Como administrador quiero registrar un integrante del club para
    //gestionarlos.
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody PaymentDTO ycqtdto){
        ModelMapper ycqtm=new ModelMapper();
        Payment ycqtt=ycqtm.map(ycqtdto, Payment.class);
        ycqtpS.insert(ycqtt);
    }




    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<PaymentDTO> lista() {
        return ycqtpS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, PaymentDTO.class);
        }).collect(Collectors.toList());

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/reporte1/{code_member}")
    public List<PaymentbyIdDTO>list2(@PathVariable("code_member") Long ycqtid){
        List<String[]>lista=ycqtpS.PaymentbyId(ycqtid);
        List<PaymentbyIdDTO>ycqtlistaDTO=new ArrayList<>();
        for(String[] data:lista){
            PaymentbyIdDTO dto=new PaymentbyIdDTO();
            dto.setYcqtid(Long.parseLong(data[0]));
            dto.setYcqtyear(data[1]);
            dto.setYcqtamount(Double.parseDouble(data[2]));
            dto.setYcqtmonth(data[3]);
            dto.setYcsqtstatus(Boolean.parseBoolean(data[4]));
            ycqtlistaDTO.add(dto);
        }
        return ycqtlistaDTO;
    }

    @GetMapping("/id/{code_member}")
    public PaymentDTO listarId(@PathVariable("code_member") Long id) {
        ModelMapper m=new ModelMapper();
        PaymentDTO dto=m.map(ycqtpS.listarId(id),PaymentDTO.class);
        return dto;
    }
}
