package com.example.jehunonboarding.repository;

import com.example.jehunonboarding.domain.ResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<ResumeEntity, Long> {

    Optional<ResumeEntity> findByMemberIdAndCompanyId(int memberId, int companyId);

}
