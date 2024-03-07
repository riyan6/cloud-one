package com.example.cloud.user.controller;

import com.funcode.common.model.web.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "用户 服务")
@RestController
@RequestMapping("/api/user/users")
@RequiredArgsConstructor
public class UserController {

    @Operation(summary = "获取单个用户的数据根据用户ID")
    @Parameter(name = "keyword", description = "关键字", in = ParameterIn.PATH, required = true)
    @GetMapping("/{id}/profile")
    public ApiResult<String> profile(@PathVariable String id) {
        return ApiResult.success("找不到%s的用户数据".formatted(id));
    }

}
