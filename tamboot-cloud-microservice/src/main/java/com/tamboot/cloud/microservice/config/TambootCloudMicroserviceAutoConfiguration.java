package com.tamboot.cloud.microservice.config;

import com.tamboot.cloud.microservice.mybatis.CreateInfoInsertStrategy;
import com.tamboot.cloud.microservice.mybatis.ModifyInfoUpdateStrategy;
import com.tamboot.mybatis.config.TambootMybatisAutoConfiguration;
import com.tamboot.mybatis.id.SnowFlakeIdGeneratorFactory;
import com.tamboot.mybatis.strategy.InsertStrategy;
import com.tamboot.mybatis.strategy.UpdateStrategy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TambootCloudMicroserviceAutoConfiguration {

    @Configuration
    @ConditionalOnClass(TambootMybatisAutoConfiguration.class)
    public static class CloudMybatisCustomConfiguration {
        @Bean
        public InsertStrategy insertStrategy(SnowFlakeIdGeneratorFactory idFactory) {
            return new CreateInfoInsertStrategy(idFactory);
        }

        @Bean
        public UpdateStrategy updateStrategy() {
            return new ModifyInfoUpdateStrategy();
        }
    }
}
