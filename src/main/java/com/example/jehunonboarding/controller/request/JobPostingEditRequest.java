package com.example.jehunonboarding.controller.request;

import lombok.Data;

@Data
public class JobPostingEditRequest {
    private String companyName;
    private String nation;
    private String region;
    private String jobPosition;
    private long jobCompensation;
    private String description;
    private String skill;
}
