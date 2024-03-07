package com.example.cloud.search.controller;

import com.example.cloud.user.sdk.UserBalanceService;
import com.example.cloud.user.sdk.UserService;
import com.funcode.common.model.web.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Tag(name = "SubTitleCat 检索服务")
@RestController
@RequestMapping("/api/search/subtitleCat")
public class SubTitleCatController {

    //@DubboReference(timeout = 10000)
    //private UserService userService;

    @Operation(summary = "根据关键字检索数据", description = "基础查询")
    @Parameter(name = "keyword", description = "关键字", in = ParameterIn.PATH, required = true)
    @GetMapping("/search/{keyword}")
    public ApiResult<String> search(@PathVariable String keyword) {
        return ApiResult.success("没有找到任何关于%s的信息".formatted(keyword));
    }

    @Operation(summary = "获取某个用户的检索历史")
    @Parameter(name = "id", description = "用户id", in = ParameterIn.PATH, required = true)
    @GetMapping("/{id}/history")
    public ApiResult<String> searchHistory(@PathVariable("id") long id) {

//        CompletableFuture<String> future = userService.sayHello("米小虎");
//        future.whenComplete((v, t) -> {
//           if (t != null) {
//               t.printStackTrace();
//           } else {
//               log.info("sayHello response:" + v);
//           }
//        });
//        log.info("sayHello 在响应返回之前执行。");


        return ApiResult.success("没有找到");
    }

}
