package com.ayush.kafka.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class WikimediaChangesProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        // to read real time stream data from wikimedia, we use event source
        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate);
        String url ="https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(url)).build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);

    }
}
