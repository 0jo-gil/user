package com.zerobase.fastlms.util;

import javax.servlet.http.HttpServletRequest;

public class ClientIpUtil {

    public static String getClientIp (HttpServletRequest request){
        return
                (null != request.getHeader("X-FORWARDED-FOR")) ? request.getHeader("X-FORWARDED-FOR") : request.getRemoteAddr();
    }

}
