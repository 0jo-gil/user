package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.admin.dto.MemberLogDto;
import com.zerobase.fastlms.admin.model.MemberLogParam;
import com.zerobase.fastlms.member.model.MemberLogInput;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MemberLogService {
    /**
     * 유저 로그인 로그 등록
     */
    boolean register(MemberLogInput parameter);

    /**
     * 유저 로그 기록 출력
     */
    List<MemberLogDto> list(String userId);

}
