package com.ayush.kafka.consumer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="wikimedia_recentChanges")
@Data
public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    @Column(length = 3000)
    private String wikiEventData;
}
