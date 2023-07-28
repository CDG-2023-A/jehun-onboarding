package com.example.jehunonboarding.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JobPostingApplyRequest {
    @NotNull(message = "companyId가 존재하지 않습니다")
    private int companyId;
    @NotNull(message = "memberId가 존재하지 않습니다")
    private int memberId;
}
