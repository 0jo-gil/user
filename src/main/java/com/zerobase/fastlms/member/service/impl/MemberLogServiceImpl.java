package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.entity.MemberLog;
import com.zerobase.fastlms.member.model.MemberLogInput;
import com.zerobase.fastlms.member.repository.MemberLogRepository;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberLogServiceImpl implements MemberLogService {
    private final MemberRepository memberRepository;
    private final MemberLogRepository memberLogRepository;
    @Override
    public boolean register(
            MemberLogInput parameter
            ) {
        Optional<Member> optionalMember = memberRepository.findById(parameter.getUserId());

        if(!optionalMember.isPresent()){
            return false;
        }


        MemberLog memberLog = MemberLog.builder()
                .userId(parameter.getUserId())
                .userIp(parameter.getUserIp())
                .connectDt(LocalDateTime.now())
                .userUA(parameter.getUserUA())
                .build();

        memberLogRepository.save(memberLog);

        return true;
    }


}
