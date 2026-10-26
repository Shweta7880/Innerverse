
package com.innerverse.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Column;

@Entity
public class JournalReflection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String actionTried;

    @Enumerated(EnumType.STRING)
    private Helpfullness helpfulness;

    @ManyToOne
    @JoinColumn(name = "journal_entry_id")
    private JournalEntry journalEntry;

    public JournalReflection() {
    }

    public Long getId() {
        return id;
    }

    public String getActionTried() {
        return actionTried;
    }

    public void setActionTried(String actionTried) {
        this.actionTried = actionTried;
    }

    public Helpfullness getHelpfulness() {
        return helpfulness;
    }

    public void setHelpfulness(Helpfullness helpfulness) {
        this.helpfulness = helpfulness;
    }

    public JournalEntry getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(JournalEntry journalEntry) {
        this.journalEntry = journalEntry;
    }
}
