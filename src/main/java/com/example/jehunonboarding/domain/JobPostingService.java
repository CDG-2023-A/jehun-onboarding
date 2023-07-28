package com.example.jehunonboarding.domain;

import com.example.jehunonboarding.repository.CompanyRepository;
import com.example.jehunonboarding.repository.JobPostingRepository;
import com.example.jehunonboarding.repository.ResumeRepository;
import com.example.jehunonboarding.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    private final JobPostingRepository jobPostingRepository;
    private final CompanyRepository companyRepository;
    private final MemberRepository memberRepository;
    private final ResumeRepository resumeRepository;

    public void register(JobPostingRegisterInfo registerInfo) {
        companyRepository.findById(registerInfo.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회사입니다."));

        jobPostingRepository.save(
                new JobPostingEntity(
                        registerInfo.getCompanyId(),
                        registerInfo.getJobPosition(),
                        registerInfo.getJobCompensation(),
                        registerInfo.getDescription(),
                        registerInfo.getSkill()
                )
        );
    }

    public List<JobPosting> search(Pageable pageable, String keyword) {
        return jobPostingRepository.findByKeyword(pageable, keyword);
    }

    public void apply(int companyId, int memberId) {
        companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회사입니다."));

        memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        resumeRepository.findByMemberIdAndCompanyId(memberId, companyId)
                .ifPresent(resume -> {
                    throw new IllegalArgumentException("이미 지원이 완료되었습니다.");
                });

        resumeRepository.save(new ResumeEntity(memberId, companyId));
    }
}
