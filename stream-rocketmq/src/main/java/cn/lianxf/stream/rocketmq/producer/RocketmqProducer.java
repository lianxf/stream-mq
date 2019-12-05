package cn.lianxf.stream.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author beyond09.hik
 * @version 1.0
 * @className RocketmqProducer
 * @description rocketmq 消息生产者
 * @date 2019/12/5 3:15
 */
@Service
public class RocketmqProducer {

    @Value("${spring.cloud.stream.rocketmq.binder.namesrv-addr}")
    private String namesrvAddr;

    @Value("${spring.cloud.stream.bindings.output.destination}")
    private String destination;

    @Value("${spring.cloud.stream.bindings.output.group}")
    private String group;

    @Value("${spring.cloud.stream.bindings.output.tag}")
    private String tag;


    /**
     * 发送<code>String</code> 类型的消息
     * @author beyond09.hik
     * @date 3:37 2019/12/5
     * @param message 消息实体
     */
    public void send(String message) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer(UUID.randomUUID().toString().replaceAll("-",""));
        producer.setNamesrvAddr(namesrvAddr);
        producer.start();
        Message msg = new Message(destination, tag, message.getBytes());
        producer.send(msg);
    }
}
