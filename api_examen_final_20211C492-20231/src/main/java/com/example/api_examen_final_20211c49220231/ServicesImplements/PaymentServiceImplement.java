package com.example.api_examen_final_20211c49220231.ServicesImplements;


import com.example.api_examen_final_20211c49220231.Entities.Payment;
import com.example.api_examen_final_20211c49220231.Repository.PaymentRepository;
import com.example.api_examen_final_20211c49220231.ServicesInterfaces.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentServiceImplement implements IPaymentService {
    @Autowired
    private PaymentRepository ycqtPR;
    @Override
    public void insert(Payment ycqtpayment) {
        ycqtPR.save(ycqtpayment);

    }

    @Override
    public List<Payment> list() {
        return ycqtPR.findAll();
    }

    @Override
    public List<String[]> PaymentbyId(Long ycqtidmember) {
        return ycqtPR.PaymentbyId(ycqtidmember);
    }

    @Override
    public Payment listarId(Long ycqtid) {
        return ycqtPR.findById(ycqtid).orElse(new Payment());
    }
}
