package com.zerobase.fastlms.member.repository;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.admin.dto.MemberLogDto;
import com.zerobase.fastlms.admin.model.MemberLogParam;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.entity.MemberLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberLogRepository extends JpaRepository<MemberLog, String> {
    List<MemberLogDto> findByUserId(String userId);
}
