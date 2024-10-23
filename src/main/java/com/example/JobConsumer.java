package com.example;

import com.github.sonus21.rqueue.annotation.RqueueListener;
import com.github.sonus21.rqueue.listener.RqueueMessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JobConsumer {
  @RqueueListener(value = "my-delay-queue", visibilityTimeout = "10000")
  public void handleMessage(String msg, @Header(RqueueMessageHeaders.ID) String messageId) {
    System.out.println("%s Handling message (id: %s, body: %s)".formatted(Instant.now(), messageId, msg));
  }
}
