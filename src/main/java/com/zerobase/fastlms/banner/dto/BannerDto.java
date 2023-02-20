package com.zerobase.fastlms.banner.dto;


import com.zerobase.fastlms.banner.entity.Banner;
import com.zerobase.fastlms.course.dto.CourseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BannerDto {

    Long id;
    String bannerName;
    String imagePath;
    String linkPath;

    String linkTarget;

    long sortValue;
    boolean usingYn;

    LocalDate regDt;

    String filename;
    String urlFilename;

    long totalCount;
    long seq;


    public static BannerDto of(Banner banner){
        return BannerDto.builder()
                .id(banner.getId())
                .bannerName(banner.getBannerName())
                .imagePath(banner.getImagePath())
                .linkPath(banner.getLinkPath())
                .linkTarget(banner.getLinkTarget())
                .sortValue(banner.getSortValue())
                .usingYn(banner.isUsingYn())
                .regDt(banner.getRegDt())
                .filename(banner.getFilename())
                .urlFilename(banner.getUrlFilename())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners){
        if(banners == null){
            return null;
        }

        List<BannerDto> bannerList = new ArrayList<>();

        for(Banner x : banners){
            bannerList.add(BannerDto.of(x));
        }

        return bannerList;
    }


}
