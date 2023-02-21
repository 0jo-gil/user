package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.entity.MemberLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberLogDto {

    String userId;
    LocalDateTime connectDt;
    String userIp;
    String userua;
    LocalDateTime lastLoginDt;

    long seq;
    
    public static MemberLogDto of(MemberLog memberLog) {
        
        return MemberLogDto.builder()
                .userId(memberLog.getUserId())
                .connectDt(memberLog.getConnectDt())
                .userIp(memberLog.getUserIp())
                .userua(memberLog.getUserUA())
                .build();
    }
    
    
    public String getConnectDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return connectDt != null ? connectDt.format(formatter) : "";
    }
    

    public String getLastLoginDtText(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return lastLoginDt != null ? lastLoginDt.format(formatter) : "";
    }
    
}
