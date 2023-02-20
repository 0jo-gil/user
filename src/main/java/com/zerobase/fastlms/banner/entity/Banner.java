package com.zerobase.fastlms.banner.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
