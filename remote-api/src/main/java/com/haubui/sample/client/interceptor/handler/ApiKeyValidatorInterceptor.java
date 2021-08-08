// Should uncomment late

//package com.haubui.sample.client.interceptor.handler;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class ApiKeyValidatorInterceptor implements HandlerInterceptor {
//
//    private static final Logger log = LoggerFactory.getLogger(ApiKeyValidatorInterceptor.class);
//
//    public static final String INTERNAL_PATH = "/internal/";
//
//    @Value("${security.apikey}")
//    private String apikey;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        log.debug("apikey:" + apikey);
//        String path = request.getRequestURI();
//        if (path.contains(INTERNAL_PATH)) {
//            String key = request.getHeader(AppConstants.X_API_KEY) == null ? AppConstants.STRING_EMPTY : request.getHeader(AppConstants.X_API_KEY);
//
//            if (!apikey.equals(key)) {
//                String errorCode = String.valueOf(HttpStatus.FORBIDDEN.value());
//                throw new ForbiddenException(errorCode, errorCode + message);
//            }
//        }
//        return true;
//    }
//}
