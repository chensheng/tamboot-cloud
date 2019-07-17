package com.tamboot.cloud.client.config;

import com.tamboot.cloud.client.core.CloudSecurityApiRequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TambootCloudClientAutoConfiguration {

    @Configuration
    @ConditionalOnClass(name = "com.tamboot.security.util.SafeSecurityContextHolder")
    public static class CloudSecurityClientConfiguration {
        @Bean
        public CloudSecurityApiRequestInterceptor cloudSecurityApiRequestInterceptor() {
            return new CloudSecurityApiRequestInterceptor();
        }
    }
}
