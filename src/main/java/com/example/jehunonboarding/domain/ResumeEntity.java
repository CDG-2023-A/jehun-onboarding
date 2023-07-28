package com.example.jehunonboarding.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resume")
@NoArgsConstructor
public class ResumeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Long companyId;

    public ResumeEntity(int memberId, int companyId) {
        this.memberId = (long) memberId;
        this.companyId = (long) companyId;
    }
}
