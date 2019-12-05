package cn.lianxf.stream.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * @author beyond09.hik
 * @version 1.0
 * @className RockmqConsumer
 * @description rockmq 消息消费者
 * @date 2019/12/5 3:36
 */
@Slf4j
@Service
public class RockmqConsumer {


    /**
     * 默认是input，在Sink类中指定，如果想要多个input，需要写一个实现Sink的类
     * @author beyond09.hik
     * @date 4:30 2019/12/5
     * @param receiveMsg 接收到的消息
     */
    @StreamListener(Sink.INPUT)
    public void consumer(String receiveMsg) {
       log.info("[RockmqConsumer:consumer] receiver message {}", receiveMsg);
    }
}
