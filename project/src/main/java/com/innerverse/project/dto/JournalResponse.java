
    package com.innerverse.project.dto;
    import java.time.LocalDateTime;
    public class JournalResponse {

        private Long id;
        private String journalText;
        private String mood;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getJournalText() {
            return journalText;
        }

        public void setJournalText(String journalText) {
            this.journalText = journalText;
        }

        public String getMood() {
            return mood;
        }

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
    }

