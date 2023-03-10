package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.model.BannerInput;
import com.zerobase.fastlms.banner.model.BannerParam;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.model.CourseInput;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.model.ServiceResult;
import com.zerobase.fastlms.course.model.TakeCourseInput;

import java.util.List;

public interface BannerService {
    
    
    /**
     * 배너 등록
     */
    boolean add(BannerInput parameter);
    
    /**
     * 배너 정보수정
     */
    boolean set(BannerInput parameter);
    
    /**
     * 배너 목록
     */
    List<BannerDto> list(BannerParam parameter);
    
    /**
     * 배너 상세정보
     */
    BannerDto getById(long id);
    
    /**
     * 배너 내용 삭제
     */
    boolean del(String idList);
    
    /**
     * 프론트 배너 목록
     */
    List<BannerDto> showBannerList();
    
    /**
     * 프론트 배너 상세 정보
     */
    BannerDto frontDetail(long id);
    
    /**
     * 수강신청
     */
    ServiceResult req(TakeCourseInput parameter);
    
    /**
     * 전체 강좌 목록
     */
    List<CourseDto> listAll();
    
}
