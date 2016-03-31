package com.muselab.reactor.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.bus.EventBus;

import javax.annotation.PostConstruct;

import static reactor.bus.selector.Selectors.$;

@RestController
public class ReactorController {


    @Autowired
    private EventBus eventBus;

    @Autowired
    private Receiver receiver;

    @Autowired
    private Publisher publisher;

    @PostConstruct
    public void init() {
        eventBus.on($("quote"), receiver);
    }

    @RequestMapping("/hello")
    public String hello() throws Exception {

        publisher.publishTr("test");

        return "hello";
    }
}
