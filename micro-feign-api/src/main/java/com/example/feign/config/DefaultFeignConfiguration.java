package com.example.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign 配置类
 * 或在 YML文件修改
 * 定义Logger 级别
 * Remote procedure call
 *
 */
@Configuration
public class DefaultFeignConfiguration {

    @Bean //加载到IOC容器中，创建对象实例化
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }

}
