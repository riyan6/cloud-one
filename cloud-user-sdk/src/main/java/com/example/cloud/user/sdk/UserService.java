package com.example.cloud.user.sdk;

import java.util.concurrent.CompletableFuture;

public interface UserService {

    String getUserNameByUid(Long uid);

    CompletableFuture<String> sayHello(String name);

}
