package com.thc.smspr.repository;

import com.thc.smspr.domain.Tbpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//2024-07-11 추가(클래스 처음 추가함)
@Repository
public interface TbpostRepository extends JpaRepository<Tbpost, String> {
    List<Tbpost> findByTitle(String title);
}
