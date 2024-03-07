package com.example.cloud.user.service.sdk;

import com.example.cloud.user.sdk.UserBalanceService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

@DubboService(group = "dec")
public class UserBalanceServiceSdkImpl2 implements UserBalanceService {

    @Override
    public List<String> getBalanceChangeHistory() {
        return List.of("2024-01-01支出30元","2024-01-02支出100元");
    }

}
