package com.example.jehunonboarding.repository;

import com.example.jehunonboarding.domain.JobPosting;
import com.example.jehunonboarding.domain.JobPostingEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPostingRepository extends JpaRepository<JobPostingEntity, Long> {

    @Query("SELECT new com.example.jehunonboarding.domain.JobPosting(c.id, c.companyName, c.nation, c.region, jp.jobPosition, jp.jobCompensation, jp.description, jp.skill) FROM JobPostingEntity jp INNER JOIN Company c ON jp.companyId = c.id WHERE jp.jobPosition LIKE %:keyword% OR c.companyName LIKE %:keyword%")
    List<JobPosting> findByKeyword(Pageable pageable, String keyword);
    @Query("SELECT new com.example.jehunonboarding.domain.JobPosting(c.id, c.companyName, c.nation, c.region, jp.jobPosition, jp.jobCompensation, jp.description, jp.skill) FROM JobPostingEntity jp INNER JOIN Company c ON jp.companyId = c.id WHERE jp.id = :jobPostingId")
    List<JobPosting> detailPosting(int jobPostingId);
    @Query("SELECT jp.id FROM JobPostingEntity jp WHERE jp.companyId = :companyId AND jp.id = :jobPostingId")
    List<Integer> findOtherJobPostings(@Param("companyId") int companyId, @Param("jobPostingId") int jobPostingId);
}
