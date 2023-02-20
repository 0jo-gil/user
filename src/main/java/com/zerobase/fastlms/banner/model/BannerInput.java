package com.zerobase.fastlms.banner.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BannerInput {
    Long id;

    String bannerName;
    String imagePath;
    String linkPath;

    String linkTarget;

    long sortValue;
    boolean usingYn;
    LocalDate regDt;

    String idList;


    String filename;
    String urlFilename;
}
