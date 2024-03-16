package com.example.cloud.rocketmq;

import lombok.SneakyThrows;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class ProducerTest {

    @Test
    @SneakyThrows
    public void testSyncSend() {
        var producer = new DefaultMQProducer("test1");
        producer.setNamespace("localhost:9876");
        producer.start();
        Message message = new Message("base", "normal", "测试同步消息".getBytes(StandardCharsets.UTF_8));
        // send
        SendResult result = producer.send(message);
        System.out.println(result);
    }

}
