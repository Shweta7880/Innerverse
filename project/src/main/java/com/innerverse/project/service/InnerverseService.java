package com.innerverse.project.service;

import com.innerverse.project.dto.JournalRequest;
import com.innerverse.project.dto.JournalResponse;
import com.innerverse.project.exception.JournalNotFoundException;
import com.innerverse.project.model.JournalEntry;
import com.innerverse.project.repository.JournalEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InnerverseService {

    private final JournalEntryRepository repository;

    public InnerverseService(JournalEntryRepository repository) {
        this.repository = repository;
    }


    public JournalEntry processJournal(JournalRequest request) {

        JournalEntry journalEntry = new JournalEntry();
        journalEntry.setJournalText(request.getJournalText());

        System.out.println("SERVICE WAS CALLED!");

        String text = request.getJournalText().toLowerCase();

        String detectedMood;

        if (text.contains("anxious") ||
                text.contains("worried") ||
                text.contains("overwhelmed") ||
                text.contains("stress")) {

            detectedMood = "ANXIOUS";

        } else if (text.contains("happy") ||
                text.contains("excited") ||
                text.contains("great")) {

            detectedMood = "HAPPY";

        } else if (text.contains("sad") ||
                text.contains("lonely") ||
                text.contains("upset")) {

            detectedMood = "SAD";

        } else {
            detectedMood = "NEUTRAL";
        }

        journalEntry.setMood(detectedMood);

        System.out.println("Detected mood: " + detectedMood);

        return repository.save(journalEntry);
    }
    public JournalResponse convertToResponse(JournalEntry journalEntry) {

        JournalResponse response = new JournalResponse();

        response.setId(journalEntry.getId());
        response.setJournalText(journalEntry.getJournalText());
        response.setMood(journalEntry.getMood());
        response.setCreatedAt(journalEntry.getCreatedAt());
        return response;
    }
    public List<JournalEntry> getAllJournals() {
        return repository.findAll();
    }
    public JournalEntry getJournalById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new JournalNotFoundException("Journal not found with id: " + id));
    }
    public void deleteJournal(Long id) {

        JournalEntry journalEntry = repository.findById(id)
                .orElseThrow(() ->
                        new JournalNotFoundException(
                                "Journal not found with id: " + id));

        repository.delete(journalEntry);
    }
    public JournalEntry updateJournal(Long id, JournalRequest request) {


            JournalEntry existingJournal = repository.findById(id)
                    .orElseThrow(() ->
                            new JournalNotFoundException(
                                    "Journal not found with id: " + id));

            existingJournal.setJournalText(request.getJournalText());

            String text = request.getJournalText().toLowerCase();


        String detectedMood;

        if (text.contains("anxious") ||
                text.contains("worried") ||
                text.contains("overwhelmed") ||
                text.contains("stress")) {
            detectedMood = "ANXIOUS";
        } else if (text.contains("happy") ||
                text.contains("excited") ||
                text.contains("great")) {
            detectedMood = "HAPPY";
        } else if (text.contains("sad") ||
                text.contains("lonely") ||
                text.contains("upset")) {
            detectedMood = "SAD";
        } else {
            detectedMood = "NEUTRAL";
        }


        existingJournal.setMood(detectedMood);

        return repository.save(existingJournal);


    }
    public List<JournalEntry> getJournalsByMood(String mood) {
        return repository.findByMood(mood);
    }
    public Map<String, Long> getMoodStats() {

        List<JournalEntry> journals = repository.findAll();

        return journals.stream()
                .collect(Collectors.groupingBy(
                        JournalEntry::getMood,
                        Collectors.counting()
                ));
    }
}