package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.admin.dto.MemberLogDto;
import com.zerobase.fastlms.admin.mapper.MemberLogMapper;
import com.zerobase.fastlms.admin.model.MemberLogParam;
import com.zerobase.fastlms.admin.model.MemberParam;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.entity.MemberLog;
import com.zerobase.fastlms.member.model.MemberLogInput;
import com.zerobase.fastlms.member.repository.MemberLogRepository;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.member.service.MemberLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberLogServiceImpl implements MemberLogService {
    private final MemberRepository memberRepository;
    private final MemberLogMapper memberLogMapper;
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


    @Override
    public List<MemberLogDto> list(String userId) {
        long totalCount = memberLogMapper.selectListCount(userId);
        List<MemberLogDto> list = memberLogRepository.findByUserId(userId);

        int i = 0;


        System.out.println("자~~~~몇개야??? " + totalCount);

        if(!CollectionUtils.isEmpty(list)){
            for(MemberLogDto x : list){
                x.setSeq(totalCount - i);
                i++;
            }
        }
        return list;
    }
}
