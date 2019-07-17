package com.tamboot.cloud.client.core;

import com.tamboot.cloud.common.core.CloudApiHeader;
import com.tamboot.security.util.SafeSecurityContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class CloudSecurityApiRequestInterceptor implements RequestInterceptor {
    public void apply(RequestTemplate requestTemplate) {
        Long userId = SafeSecurityContextHolder.getUserId();
        if (userId != null) {
            requestTemplate.header(CloudApiHeader.USER_ID, String.valueOf(userId));
        }
    }
}
