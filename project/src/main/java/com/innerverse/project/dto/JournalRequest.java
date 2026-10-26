package com.innerverse.project.dto;
import jakarta.validation.constraints.NotBlank;
public class JournalRequest {
    @NotBlank(message = "Journal text cannot be empty")
    private String journalText;

    public String getJournalText() {
        return journalText;
    }

    public void setJournalText(String journalText) {
        this.journalText = journalText;
    }
}
