package com.example.jehunonboarding.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JobPostingEditRequest {
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
}
