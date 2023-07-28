package com.example.jehunonboarding.domain;

import com.example.jehunonboarding.repository.CompanyRepository;
import com.example.jehunonboarding.repository.JobPostingRepository;
import com.example.jehunonboarding.repository.MemberRepository;
import com.example.jehunonboarding.repository.ResumeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JobPostingServiceTest {

    @InjectMocks
    private JobPostingService jobPostingService;

    @Mock
    private JobPostingRepository jobPostingRepository;
    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private MemberRepository memberRepository;
    @Mock
    private ResumeRepository resumeRepository;

    @Test
    @DisplayName("성공")
    void testApply() {
        // given
        int companyId = 1;
        int memberId = 1;
        when(companyRepository.findById(companyId)).thenReturn(Optional.of(new Company()));
        when(memberRepository.findById(companyId)).thenReturn(Optional.of(new MemberEntity()));

        // when
        jobPostingService.apply(companyId, memberId);

        // then
        verify(companyRepository, times(1)).findById(companyId);
    }

    @Test
    @DisplayName("회사가 조회되지 않으면 에러 발생")
    void testApply_NotExistCompany() {
        // given
        int companyId = 1;
        int memberId = 1;

        // when
        assertThrows(IllegalArgumentException.class, () -> jobPostingService.apply(companyId, memberId));
    }

    @Test
    @DisplayName("회원이 조회되지 않으면 에러 발생")
    void testApply_NotExistMember() {
        // given
        int companyId = 1;
        int memberId = 1;
        when(companyRepository.findById(companyId)).thenReturn(Optional.of(new Company()));

        // when
        assertThrows(IllegalArgumentException.class, () -> jobPostingService.apply(companyId, memberId));
    }

    @Test
    @DisplayName("이미 지원된 이력서라면 에러 발생")
    void testApply_AlreadyAppliedResume() {
        // given
        int companyId = 1;
        int memberId = 1;
        when(companyRepository.findById(companyId)).thenReturn(Optional.of(new Company()));
        when(memberRepository.findById(companyId)).thenReturn(Optional.of(new MemberEntity()));
        when(resumeRepository.findByMemberIdAndCompanyId(memberId, companyId)).thenReturn(Optional.of(new ResumeEntity()));

        // when
        assertThrows(IllegalArgumentException.class, () -> jobPostingService.apply(companyId, memberId));
    }
}