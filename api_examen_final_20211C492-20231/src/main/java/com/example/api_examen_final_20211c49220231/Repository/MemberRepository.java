package com.example.api_examen_final_20211c49220231.Repository;

import com.example.api_examen_final_20211c49220231.Entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
