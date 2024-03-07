package com.example.cloud.user.service.sdk;

import com.example.cloud.user.sdk.UserBalanceService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

@DubboService(group = "inc")
public class UserBalanceServiceSdkImpl implements UserBalanceService {

    @Override
    public List<String> getBalanceChangeHistory() {
        return List.of("2024-01-01收入100元", "2024-01-02收入20元");
    }

}
