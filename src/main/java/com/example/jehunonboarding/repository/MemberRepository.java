package com.example.jehunonboarding.repository;

import com.example.jehunonboarding.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
}
