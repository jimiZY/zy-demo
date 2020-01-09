package cn.cocopup.zy.rocket.controller;

import cn.cocopup.zy.dto.Person;
import cn.cocopup.zy.rocket.service.SendMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy
 * @create 2019-11-12 19:06
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private SendMsg sendMsg;

    @GetMapping("/send")
    public String senMessage(){

        Person person = new Person("testPerson",20,"男");

        sendMsg.sendObject(person,"personObj");

        return "发送成功";
    }
}
