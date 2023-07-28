package com.example.jehunonboarding.controller;

import com.example.jehunonboarding.controller.request.*;
import com.example.jehunonboarding.controller.response.CommonResponse;
import com.example.jehunonboarding.controller.response.JobPostingFindDetailResponse;
import com.example.jehunonboarding.controller.response.JobPostingSearchResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobPostingController {

    @PostMapping("/v1/job-postings")
    public ResponseEntity<CommonResponse> register(@RequestBody JobPostingRegisterRequest request) {
        return new ResponseEntity(new CommonResponse(true), HttpStatus.OK);
    }

    @PutMapping("/v1/job-postings/{jobPostingId}")
    public ResponseEntity<CommonResponse> edit(@RequestBody JobPostingEditRequest request) {
        return new ResponseEntity(new CommonResponse(true), HttpStatus.OK);
    }

    @DeleteMapping("/v1/job-postings/{jobPostingId}")
    public ResponseEntity<CommonResponse> remove(@PathVariable int jobPostingId) {
        return new ResponseEntity(new CommonResponse(true), HttpStatus.OK);
    }

    @GetMapping("/v1/job-postings")
    public ResponseEntity<JobPostingSearchResponse> search(String keyword) {
        return new ResponseEntity(new JobPostingSearchResponse(), HttpStatus.OK);
    }

    @GetMapping("/v1/job-postings/{jobPostingId}")
    public ResponseEntity<JobPostingFindDetailResponse> findDetail(@PathVariable int jobPostingId) {
        return new ResponseEntity(new JobPostingFindDetailResponse(), HttpStatus.OK);
    }

    @PostMapping("/v1/job-postings/{jobPostingId}/apply")
    public ResponseEntity<CommonResponse> apply(@RequestBody JobPostingApplyRequest request) {
        return new ResponseEntity(new CommonResponse(true), HttpStatus.OK);
    }

}
