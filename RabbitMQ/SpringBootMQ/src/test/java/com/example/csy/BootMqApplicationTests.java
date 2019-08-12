package com.example.csy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootMqApplicationTests {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void  send(){
        String message = "Hello world";
        String receiverA = "queueA";
        String receiverB = "queueB";
        for(int i=0;i<1000;i++){
            amqpTemplate.convertAndSend(receiverA, message);
        }
        System.out.println("队列结束");
    }

    @Test
    public void topicSend() {
        String message = "hello world";
        System.out.println("发送者说 : " + message);
        String exchangeName = "topicExchange";
        String route_key= "topic.news";
        //数据message交给交换器exchange，交换器将其投递到队列中
        //监听这个队列的接收者将会收到消息
        this.amqpTemplate.convertAndSend(exchangeName, route_key, message);
    }

    @Test
    public void fanoutSend() {
        String msg = "hello world";
        amqpTemplate.convertAndSend("fanoutExchange", "", msg);
    }

    @Test
    public void directSend() {
        String beautyMessage = "内衣秀明天在XXX开展";
        String foodMessage = "黄山美食推荐：蝴蝶面";
        String exchangeName = "directExchange";
        String route_key_beauty= "beauty";
        String route_key_food= "food";
        //数据message交给交换器exchange，交换器将其投递到队列中
        //监听这个队列的接收者将会收到消息
        this.amqpTemplate.convertAndSend(exchangeName, route_key_beauty, beautyMessage);
        this.amqpTemplate.convertAndSend(exchangeName, route_key_food, foodMessage);
    }
}
