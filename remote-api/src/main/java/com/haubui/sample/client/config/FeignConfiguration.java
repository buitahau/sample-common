package com.haubui.sample.client.config;

import feign.Client;
import feign.Logger;
import feign.RequestInterceptor;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.client.HttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableFeignClients(basePackages = "com.haubui.sample")
@Import(FeignClientsConfiguration.class)
@ConditionalOnClass({ApacheHttpClient.class})
@ConditionalOnProperty(
    value = {"feign.httpclient.enabled"},
    matchIfMissing = true
)
public class FeignConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("feign", "true");
        };
    }

    @Bean
    @ConditionalOnMissingBean({Client.class})
    public Client feignClient(HttpClient httpClient) {
        return new ApacheHttpClient(httpClient);
    }
}
