package com.szp.rabbitmqtest.controller;

import com.szp.rabbitmqtest.service.SenderServiece;
import com.szp.rabbitmqtest.service.SenderWithCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/test", produces = "application/json;charset=UTF-8")
public class TestSenderController {

    @Resource
    private SenderWithCallback sendWithCallback;

    @Resource
    private SenderServiece sender;

    @RequestMapping(value="/send")
    public String sendMessage(@RequestParam(name="withCallback",required = false) boolean withCallback){
        if(withCallback) {
            sendWithCallback.send();
        }else{
            sender.send();
        }

        return "Success";
    }




}
