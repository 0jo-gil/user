package com.zerobase.fastlms.banner.service;

import com.zerobase.fastlms.banner.entity.Banner;
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
//    private final CourseMapper courseMapper;
    
    
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
        
//        LocalDate saleEndDt = getLocalDate(parameter.getSaleEndDtText());
//
//        Optional<Course> optionalCourse = courseRepository.findById(parameter.getId());
//        if (!optionalCourse.isPresent()) {
//            //수정할 데이터가 없음
//            return false;
//        }
//
//        Course course = optionalCourse.get();
//        course.setCategoryId(parameter.getCategoryId());
//        course.setSubject(parameter.getSubject());
//        course.setKeyword(parameter.getKeyword());
//        course.setSummary(parameter.getSummary());
//        course.setContents(parameter.getContents());
//        course.setPrice(parameter.getPrice());
//        course.setSalePrice(parameter.getSalePrice());
//        course.setSaleEndDt(saleEndDt);
//        course.setUdtDt(LocalDateTime.now());
//        course.setFilename(parameter.getFilename());
//        course.setUrlFilename(parameter.getUrlFilename());
//
//        courseRepository.save(course);
        
        return true;
    }
    
    @Override
    public List<CourseDto> list(BannerParam parameter) {

//
//        long totalCount = courseMapper.selectListCount(parameter);
//
//        List<CourseDto> list = courseMapper.selectList(parameter);
//        if (!CollectionUtils.isEmpty(list)) {
//            int i = 0;
//            for (CourseDto x : list) {
//                x.setTotalCount(totalCount);
//                x.setSeq(totalCount - parameter.getPageStart() - i);
//                i++;
//            }
//        }
//        return list;

        return null;
    }
    
    @Override
    public CourseDto getById(long id) {
//        return bannerRepository.findById(id).map(CourseDto::of).orElse(null);

        return null;
    }
    
    @Override
    public boolean del(String idList) {
        
//        if (idList != null && idList.length() > 0) {
//            String[] ids = idList.split(",");
//            for (String x : ids) {
//                long id = 0L;
//                try {
//                    id = Long.parseLong(x);
//                } catch (Exception e) {
//                }
//
//                if (id > 0) {
//                    courseRepository.deleteById(id);
//                }
//            }
//        }
        
        return true;
    }
    
    @Override
    public List<CourseDto> frontList(CourseParam parameter) {
//
//        if (parameter.getCategoryId() < 1) {
//            List<Course> courseList = courseRepository.findAll();
//            return CourseDto.of(courseList);
//        }
//
//        Optional<List<Course>> optionalCourses = courseRepository.findByCategoryId(parameter.getCategoryId());
//        if (optionalCourses.isPresent()) {
//            return CourseDto.of(optionalCourses.get());
//        }
        return null;
    }
    
    @Override
    public CourseDto frontDetail(long id) {
        
//        Optional<Course> optionalCourse = courseRepository.findById(id);
//        if (optionalCourse.isPresent()) {
//            return CourseDto.of(optionalCourse.get());
//        }
        return null;
    }
    
    /**
     * 수강신청
     */
    @Override
    public ServiceResult req(TakeCourseInput parameter) {
//
//        ServiceResult result = new ServiceResult();
//
//        Optional<Course> optionalCourse = courseRepository.findById(parameter.getCourseId());
//        if (!optionalCourse.isPresent()) {
//            result.setResult(false);
//            result.setMessage("강좌 정보가 존재하지 않습니다.");
//            return result;
//        }
//
//        Course course = optionalCourse.get();
//
//        //이미 신청정보가 있는지 확인
//        String[] statusList = {TakeCourse.STATUS_REQ, TakeCourse.STATUS_COMPLETE};
//        long count = takeCourseRepository.countByCourseIdAndUserIdAndStatusIn(course.getId(), parameter.getUserId(), Arrays.asList(statusList));
//
//        if (count > 0) {
//            result.setResult(false);
//            result.setMessage("이미 신청한 강좌 정보가 존재합니다.");
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


























