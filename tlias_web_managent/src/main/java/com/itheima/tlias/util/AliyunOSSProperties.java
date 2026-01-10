package com.itheima.tlias.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 阿里云OSS配置属性
@Data
@Component// 将当前类对象，注入到spring容器中
@ConfigurationProperties(prefix = "aliyun.oss")// 指定当前类对应的配置属性的前缀
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
}
