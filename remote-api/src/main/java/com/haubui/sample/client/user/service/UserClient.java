package com.haubui.sample.client.user.service;

import com.haubui.sample.client.config.FeignConfiguration;
import com.haubui.sample.client.user.domain.UserResponse;
import com.haubui.sample.client.user.dto.UserDto;
import com.haubui.sample.common.exception.GeneralException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user", url = "${feign.client.user.url}", configuration = FeignConfiguration.class)
public interface UserClient {

    @PostMapping("/api/v1/verify-account")
    UserResponse verifyAccount(@RequestBody UserDto userDto) throws GeneralException;

    @GetMapping("/api/v1/{userId}")
    UserResponse getById(@PathVariable("userId") String userId);
}
