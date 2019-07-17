package com.tamboot.cloud.microservice.core;

import com.tamboot.cloud.common.core.CloudApiHeader;
import com.tamboot.common.tools.text.TextUtil;

import javax.servlet.http.HttpServletRequest;

public class CloudApiContextHolder {
    public static Long getUserId() {
        HttpServletRequest request = HttpRequestHolder.getServletRequest();
        if (request == null) {
            return null;
        }

        String userIdText = request.getHeader(CloudApiHeader.USER_ID);
        if (TextUtil.isEmpty(userIdText)) {
            return null;
        }

        try {
            return Long.parseLong(userIdText);
        } catch (NumberFormatException e) {
        }
        return null;
    }
}
