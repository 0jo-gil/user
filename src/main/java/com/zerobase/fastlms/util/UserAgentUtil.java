package com.zerobase.fastlms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAgentUtil {
    public static String getUserAgent(
            HttpServletRequest request
    ){
        return request.getHeader("user-agent");
    }
}
