package com.ayush.kafka.consumer.repository;

import com.ayush.kafka.consumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaData, Long> {
}
