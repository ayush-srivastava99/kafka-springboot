package com.ayush.kafka.consumer;

import com.ayush.kafka.consumer.entity.WikimediaData;
import com.ayush.kafka.consumer.repository.WikimediaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaDatabaseConsumer {

private WikimediaRepository repository;

public  KafkaDatabaseConsumer(WikimediaRepository repository)
{
    this.repository=repository;
}
    @KafkaListener(topics = "wikimedia_recentchanges", groupId = "myGroup")
    public void consume(String eventMessage)
    {
        log.info("Message received->{}",eventMessage);
        WikimediaData data=new WikimediaData();
        data.setWikiEventData(eventMessage);
        repository.save(data);
    }
}
