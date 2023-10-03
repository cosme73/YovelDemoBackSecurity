package com.example.api_examen_final_20211c49220231.Repository;

import com.example.api_examen_final_20211c49220231.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    public Users findByYcqtusername(String ycqtusername);
}
