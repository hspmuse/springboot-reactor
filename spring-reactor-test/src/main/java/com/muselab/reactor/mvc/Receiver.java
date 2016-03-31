package com.muselab.reactor.mvc;

import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.fn.Consumer;

@Service
public class Receiver implements Consumer<Event<String>> {

    @Override
    public void accept(Event<String> str) {
//        try {
//            Thread.sleep(2000);
//        } catch(Exception e) {
//        }
        System.out.println("Receiver str=" + str.getData());
    }
}
