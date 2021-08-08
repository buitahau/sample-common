package com.haubui.sample.client.interceptor.request;

import com.haubui.sample.common.utils.SecurityUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    private Logger logger = LoggerFactory.getLogger(FeignClientInterceptor.class);
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String HEADER_LOCALE = "X-locale";
    private static final String X_API_KEY = "X-Api-Key";
    private static final String HEADER_USER_AGENT= "X-User-Agent";
    private static final String BEARER = "Bearer";

//    @Value("${security.apikey:}")
//    private String apikey;

    @Override
    public void apply(RequestTemplate template) {
        try {
//            template.header(X_API_KEY, apikey);
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            addLocaleHeader(request, template);
            addUserAgentHeader(request, template);
            SecurityUtil.getCurrentUserJWT().ifPresent(s -> template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER, s)));
        } catch (Exception e) {
        }
    }

    private void addLocaleHeader( HttpServletRequest request, RequestTemplate template) {
        String locale = request.getHeader(HEADER_LOCALE);
        if (StringUtils.isNoneBlank(locale)) {
            template.header(HEADER_LOCALE, locale);
        }
    }
    private void addUserAgentHeader( HttpServletRequest request, RequestTemplate template) {
        String userAgent = request.getHeader(HEADER_USER_AGENT);
        logger.debug("User-Agent: {}", userAgent);
        if (StringUtils.isNoneBlank(userAgent)) {
            template.header(HEADER_USER_AGENT, userAgent);
        }
    }
}
