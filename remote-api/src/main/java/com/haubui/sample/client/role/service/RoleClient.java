package com.haubui.sample.client.role.service;

import com.haubui.sample.client.config.FeignConfiguration;
import com.haubui.sample.client.role.domain.RoleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "role", url = "${feign.client.role.url}", configuration = FeignConfiguration.class)
public interface RoleClient {

    @GetMapping("/api/v1/internal/user/{userId}")
    List<RoleResponse> getRoles(@PathVariable("userId") String userId);
}
