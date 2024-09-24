package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，用于创建AliOssUtil对象
 */

@Configuration
@Slf4j
public class OssConfiguration {

    @Bean
    @ConditionalOnMissingBean //保证AOP容器中只有一个AliOssUtil对象
    public AliOssUtil aliossUtil(AliOssProperties aop) {
        log.info("开始创建阿里云文件上传工具类对象：{}", aop);
        return new AliOssUtil(aop.getEndpoint(), aop.getAccessKeyId(),
                aop.getAccessKeySecret(), aop.getBucketName());
    }
}
