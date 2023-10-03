package com.example.api_examen_final_20211c49220231.ServicesInterfaces;

import com.example.api_examen_final_20211c49220231.Entities.Payment;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPaymentService {

    public void insert(Payment ycqtpayment);
    public List<Payment> list();

    List<String[]> PaymentbyId( Long ycqtidmember);

    public Payment listarId(Long ycqtid);

}
