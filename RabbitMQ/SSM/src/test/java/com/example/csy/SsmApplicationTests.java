package com.example.csy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsmApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void directSend() {
        String beautyMessage = "内衣秀明天在XXX开展";
        String exchangeName = "local::mq07:exchange:e01";
        String route_key = "mq07::routeKey_robbing";
        //数据message交给交换器exchange，交换器将其投递到队列中
        //监听这个队列的接收者将会收到消息
        this.amqpTemplate.convertAndSend(exchangeName, route_key, beautyMessage);
    }
}
