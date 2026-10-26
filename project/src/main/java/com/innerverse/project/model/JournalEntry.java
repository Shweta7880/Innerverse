package com.innerverse.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
@Entity
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String journalText;

    private String mood;

    // No-argument constructor required by JPA
    public JournalEntry() {
    }

    // Constructor
    public JournalEntry(String journalText, String mood) {
        this.journalText = journalText;
        this.mood = mood;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Getter for journalText
    public String getJournalText() {
        return journalText;
    }

    // Setter for journalText
    public void setJournalText(String journalText) {
        this.journalText = journalText;
    }

    // Getter for mood
    public String getMood() {
        return mood;
    }

    // Setter for mood
    public void setMood(String mood) {
        this.mood = mood;
    }
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    public void setCreationTime() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}