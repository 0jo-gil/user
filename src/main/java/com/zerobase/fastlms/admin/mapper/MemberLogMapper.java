package com.zerobase.fastlms.admin.mapper;


import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.admin.dto.MemberLogDto;
import com.zerobase.fastlms.admin.model.MemberLogParam;
import com.zerobase.fastlms.admin.model.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberLogMapper {
    long selectListCount(String userId);
    List<MemberLogDto> selectList(MemberLogParam parameter);

}
