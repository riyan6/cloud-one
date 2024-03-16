package com.example.cloud.controller;

import com.funcode.common.model.web.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/other")
@RestController("/others")
public class OtherController {

    @GetMapping("/info")
    public ApiResult<String> info() {
        return ApiResult.success("香菜");
    }

}
