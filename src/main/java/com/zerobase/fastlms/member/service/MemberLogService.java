package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.member.model.MemberLogInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberLogService {
    /**
     * 유저 로그인 로그 등록
     */
    boolean register(MemberLogInput parameter);

}
