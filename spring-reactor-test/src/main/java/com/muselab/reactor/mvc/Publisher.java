package com.muselab.reactor.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.bus.EventBus;

@Service
public class Publisher {

    @Autowired
    EventBus eventBus;

    public void publishTr(String str) throws InterruptedException {

        System.out.println("start time=" + System.currentTimeMillis());



        eventBus.notify("quote", Event.wrap(str));

        System.out.println("end time=" + System.currentTimeMillis());
    }
}
