package com.zerobase.fastlms.member.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberLogInput {
    private String userId;
    private String userIp;
    private LocalDateTime connectDt;
    private String userUA;
}
