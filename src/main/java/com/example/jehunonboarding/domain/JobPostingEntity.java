package com.example.jehunonboarding.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "job_posting")
@NoArgsConstructor
public class JobPostingEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private int companyId;

    @Column(nullable = false)
    private String jobPosition;

    @Column(nullable = false)
    private long jobCompensation;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String skill;

    // 채용공고 지원에서 필요하며 중복을 피하기 위한 HashSet
    @ElementCollection
    private Set<String> applicants = new HashSet<>();

    public JobPostingEntity(int companyId, String jobPosition, long jobCompensation, String description, String skill) {
        this.companyId = companyId;
        this.jobPosition = jobPosition;
        this.jobCompensation = jobCompensation;
        this.description = description;
        this.skill = skill;
    }

    public void JobPostingEdit(@Valid JobPostingEditInfo editInfo) {
        this.jobPosition = editInfo.getJobPosition();
        this.jobCompensation = editInfo.getJobCompensation();
        this.description = editInfo.getDescription();
        this.skill = editInfo.getSkill();
    }

    public boolean JobPostingRemove(int companyId, int jobPostingId) {
        if (this.companyId == companyId && this.id == jobPostingId) {
            return true; // 채용공고의 회사와 삭제 요청의 회사가 일치하고, 채용공고 ID도 일치하는 경우 true를 반환
        }
        return false; // 그렇지 않은 경우 false를 반환
    }

    public boolean isApplicant(String userId) {
        return applicants.contains(userId);
    }

    public void addApplicant(int userId) {
        applicants.add(String.valueOf(userId));
    }

    public static int getJobPostingId(int integer) {
        return Math.toIntExact(integer);
    }
}
