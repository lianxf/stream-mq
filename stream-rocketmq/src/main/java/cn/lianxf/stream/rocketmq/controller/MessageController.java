package cn.lianxf.stream.rocketmq.controller;

import cn.lianxf.stream.rocketmq.producer.RocketmqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beyond09.hik
 * @version 1.0
 * @className MessageController
 * @description 消息发送测试
 * @date 2019/12/5 6:02
 */
@RequestMapping("/msg")
@RestController
public class MessageController {

    @Autowired
    private RocketmqProducer rocketmqProducer;


    @RequestMapping("/send")
    public String send() {
        try {
            for (int i = 0; i < 100; i++) {
                rocketmqProducer.send("test "+ i + " message !");
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
