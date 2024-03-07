package com.example.cloud.user.service.sdk;

import com.example.cloud.user.sdk.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.CompletableFuture;

@DubboService
public class UserServiceSdkImpl implements UserService {

    @Value("${server.port}")
    private String port;

    @Override
    public String getUserNameByUid(Long uid) {
        if (Long.valueOf(10066993).equals(uid)) {
            return "梦醒何时尔" + " by " + this.port;
        }
        return "找不到用户信息" + " by " + this.port;
    }

    @Override
    public CompletableFuture<String> sayHello(String name) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(name + ": 你好");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "异步返回的结果";
        });
    }

}
