package com.softart.dferestapi.configuration.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@ConfigurationProperties("dfe.storage.s3")
public class S3Properties {
    private String bucket;

    public void setBucket(String bucket) {
        System.setProperty("com.softart.dfe.chain.cache", "s3");
        System.setProperty("com.softart.dfe.process.cte", "s3");
        System.setProperty("com.softart.dfe.process.mdfe", "s3");
        System.setProperty("com.softart.dfe.process.nf", "s3");
        System.setProperty("com.softart.dfe.storage.default", "s3");
        System.setProperty("com.softart.dfe.s3.bucket", bucket);
        this.bucket = bucket;
    }
}
