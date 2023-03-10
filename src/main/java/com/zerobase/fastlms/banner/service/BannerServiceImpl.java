package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.admin.entity.Category;
import com.zerobase.fastlms.banner.dto.BannerDto;
import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.banner.mapper.BannerMapper;
import com.zerobase.fastlms.banner.model.BannerInput;
import com.zerobase.fastlms.banner.model.BannerParam;
import com.zerobase.fastlms.banner.repository.BannerRepository;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.entity.Course;
import com.zerobase.fastlms.course.entity.TakeCourse;
import com.zerobase.fastlms.course.mapper.CourseMapper;
import com.zerobase.fastlms.course.model.CourseInput;
import com.zerobase.fastlms.course.model.CourseParam;
import com.zerobase.fastlms.course.model.ServiceResult;
import com.zerobase.fastlms.course.model.TakeCourseInput;
import com.zerobase.fastlms.course.repository.CourseRepository;
import com.zerobase.fastlms.course.repository.TakeCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {
    
    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    private Sort getSortBySortValueDesc(){
        return Sort.by(Sort.Direction.DESC, "sortValue");
    }
    
    
    private LocalDate getLocalDate(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(value, formatter);
        } catch (Exception e) {
        
        }
        
        return null;
    }
    
    @Override
    public boolean add(BannerInput parameter) {
//        LocalDate regDtText = getLocalDate(parameter.getRegDt());
        Banner banner = Banner.builder()
                .bannerName(parameter.getBannerName())
                .imagePath(parameter.getImagePath())
                .linkPath(parameter.getLinkPath())
                .linkTarget(parameter.getLinkTarget())
                .sortValue(parameter.getSortValue())
                .usingYn(parameter.isUsingYn())
                .regDt(LocalDate.now())
                .filename(parameter.getFilename())
                .urlFilename(parameter.getUrlFilename())
                .build();
        bannerRepository.save(banner);

        return true;
    }
    
    @Override
    public boolean set(BannerInput parameter) {
        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());
        if (!optionalBanner.isPresent()) {
            return false;
        }
        Banner banner = optionalBanner.get();

        banner.setBannerName(parameter.getBannerName());
        banner.setImagePath(parameter.getImagePath());
        banner.setLinkPath(parameter.getLinkPath());
        banner.setLinkTarget(parameter.getLinkTarget());
        banner.setSortValue(parameter.getSortValue());
        banner.setUsingYn(parameter.isUsingYn());
        banner.setUdtDt(getLocalDate(LocalDate.now().toString()));
        banner.setFilename(parameter.getFilename());
        banner.setUrlFilename(parameter.getUrlFilename());

        bannerRepository.save(banner);
        
        return true;
    }
    
    @Override
    public List<BannerDto> list(BannerParam parameter) {
        List<Banner> banners = bannerRepository.findAll(getSortBySortValueDesc());

        long totalCount = bannerMapper.selectListCount(parameter);
        List<BannerDto> list = BannerDto.of(banners);

        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }
        return list;
    }
    
    @Override
    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }
    
    @Override
    public boolean del(String idList) {
        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }

        return true;
    }
    
    @Override
    public List<BannerDto> showBannerList() {
        List<Banner> bannerList = bannerRepository.findAll();
        Optional<List<Banner>> optionalBanners = null;

        for(Banner x : bannerList){
            if(x.isUsingYn()){
                optionalBanners = bannerRepository.findByUsingYn(x.isUsingYn());
            }
        }

        if (optionalBanners.isPresent()) {
            return BannerDto.of(optionalBanners.get());
        }

        return null;
    }
    
    @Override
    public BannerDto frontDetail(long id) {

//        Optional<Course> optionalCourse = courseRepository.findById(id);
//        if (optionalCourse.isPresent()) {
//            return CourseDto.of(optionalCourse.get());
//        }
        return null;
    }
    
    /**
     * ????????????
     */
    @Override
    public ServiceResult req(TakeCourseInput parameter) {
//
//        ServiceResult result = new ServiceResult();
//
//        Optional<Course> optionalCourse = courseRepository.findById(parameter.getCourseId());
//        if (!optionalCourse.isPresent()) {
//            result.setResult(false);
//            result.setMessage("?????? ????????? ???????????? ????????????.");
//            return result;
//        }
//
//        Course course = optionalCourse.get();
//
//        //?????? ??????????????? ????????? ??????
//        String[] statusList = {TakeCourse.STATUS_REQ, TakeCourse.STATUS_COMPLETE};
//        long count = takeCourseRepository.countByCourseIdAndUserIdAndStatusIn(course.getId(), parameter.getUserId(), Arrays.asList(statusList));
//
//        if (count > 0) {
//            result.setResult(false);
//            result.setMessage("?????? ????????? ?????? ????????? ???????????????.");
//            return result;
//        }
//
//        TakeCourse takeCourse = TakeCourse.builder()
//                .courseId(course.getId())
//                .userId(parameter.getUserId())
//                .payPrice(course.getSalePrice())
//                .regDt(LocalDateTime.now())
//                .status(TakeCourse.STATUS_REQ)
//                .build();
//        takeCourseRepository.save(takeCourse);
//
//        result.setResult(true);
//        result.setMessage("");
//        return result;
        return null;
    }
    
    @Override
    public List<CourseDto> listAll() {
//
//        List<Course> courseList = courseRepository.findAll();
        
//        return CourseDto.of(courseList);
        return null;
    }
    
}


























