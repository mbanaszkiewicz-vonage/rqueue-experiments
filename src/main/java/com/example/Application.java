package com.example;

import com.github.sonus21.rqueue.config.SimpleRqueueListenerContainerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  @Bean
  public SimpleRqueueListenerContainerFactory simpleRqueueListenerContainerFactory() {
    SimpleRqueueListenerContainerFactory simpleRqueueListenerContainerFactory =
        new SimpleRqueueListenerContainerFactory();
    simpleRqueueListenerContainerFactory.setPollingInterval(1000);
    return simpleRqueueListenerContainerFactory;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


}
