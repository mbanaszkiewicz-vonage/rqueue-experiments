package com.example;

import com.github.sonus21.rqueue.core.ReactiveRqueueMessageEnqueuer;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class JobProducer implements ApplicationListener<ApplicationReadyEvent> {
  private final ReactiveRqueueMessageEnqueuer reactiveRqueueMessageEnqueuer;

  JobProducer(ReactiveRqueueMessageEnqueuer reactiveRqueueMessageEnqueuer) {
    this.reactiveRqueueMessageEnqueuer = reactiveRqueueMessageEnqueuer;
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    System.out.println(Instant.now() + " calling enqueuePeriodic...");
    reactiveRqueueMessageEnqueuer.enqueuePeriodic(
        "my-delay-queue",
        "MSG_ID",
        "MSG_BODY",
        5000).block();
  }
}
