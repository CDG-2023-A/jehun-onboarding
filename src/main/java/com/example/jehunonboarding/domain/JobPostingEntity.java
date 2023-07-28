package com.example.jehunonboarding.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

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

    public JobPostingEntity(int companyId, String jobPosition, long jobCompensation, String description, String skill) {
        this.companyId = companyId;
        this.jobPosition = jobPosition;
        this.jobCompensation = jobCompensation;
        this.description = description;
        this.skill = skill;
    }
}
