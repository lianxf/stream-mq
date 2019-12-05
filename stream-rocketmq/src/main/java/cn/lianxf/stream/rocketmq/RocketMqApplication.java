package cn.lianxf.stream.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author beyond09.hik
 * @version 1.0
 * @className RocketMqApplication
 * @description 程序主入口类
 * @date 2019/12/5 3:13
 */
@SpringBootApplication(exclude = {TransactionAutoConfiguration.class})
@EnableBinding({ Source.class, Sink.class })
public class RocketMqApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketMqApplication.class, args);
    }
}
