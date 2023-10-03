package com.example.api_examen_final_20211c49220231.Repository;

import com.example.api_examen_final_20211c49220231.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
/*
    @Query(value = "select * from payment p\n" +
            " join member m on p.ycqtid = m.ycqtid\n" +
            " where m.ycqtid=:ycqtidmember", nativeQuery = true)
    List<String[]> PaymentbyId(@Param("ycqtidmember") Long ycqtidmember);


 */


    @Query(value = "select p.ycqtid, p.ycqtmonth, p.ycqtyear, p.ycqtamount, p.ycsqtstatus from payment p\n" +
            " where ycqtid_member=:ycqtidmember", nativeQuery = true)
    List<String[]> PaymentbyId(@Param("ycqtidmember") Long ycqtidmember);


}
