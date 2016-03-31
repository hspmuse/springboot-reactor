package com.muselab.reactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import reactor.Environment;
import reactor.bus.EventBus;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.muselab.reactor")
public class SpringReactorTest01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactorTest01Application.class, args);
	}

	@Bean
	Environment env() {
		return Environment.initializeIfEmpty().assignErrorJournal();
	}

	@Bean
	EventBus createEventsBus(Environment env) { return EventBus.create(env, Environment.THREAD_POOL);}
}
