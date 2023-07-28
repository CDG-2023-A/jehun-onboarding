package com.example.jehunonboarding.controller.request;

import com.example.jehunonboarding.domain.JobPostingRegisterInfo;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JobPostingRegisterRequest {
    @NotNull
    private int companyId;
    @NotNull
    private String jobPosition;
    @NotNull
    private long jobCompensation;
    @NotNull
    private String description;
    @NotNull
    private String skill;

    public JobPostingRegisterInfo toDomain() {
        return new JobPostingRegisterInfo(companyId, jobPosition, jobCompensation, description, skill);
    }
}
