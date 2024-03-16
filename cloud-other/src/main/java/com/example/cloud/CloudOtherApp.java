package com.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executors;

@SpringBootApplication
public class CloudOtherApp {

    /**
     * 主程序
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CloudOtherApp.class, args);
    }

    /**
     * 设置 tomcat 每处理一个 http 请求用虚拟线程去处理
     *
     * @return
     */
    @Bean
    public TomcatProtocolHandlerCustomizer<?> protocolHandlerCustomizer() {
        return protocolHandler -> protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
    }

}
