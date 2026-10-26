package com.innerverse.project.Controller;

import com.innerverse.project.dto.JournalRequest;
import com.innerverse.project.dto.JournalResponse;
import com.innerverse.project.model.JournalEntry;
import com.innerverse.project.service.InnerverseService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class InnerverseController {

    private final InnerverseService innerverseService;

    public InnerverseController(InnerverseService innerverseService) {
        this.innerverseService = innerverseService;
    }

    @PostMapping("/journal")
    public JournalResponse createJournal(@RequestBody @Valid JournalRequest request) {
        JournalEntry journalEntry = innerverseService.processJournal(request);
       return  innerverseService.convertToResponse(journalEntry);
    }
    @GetMapping("/journal")
    public List<JournalResponse> getAllJournals() {

        List<JournalEntry> journals = innerverseService.getAllJournals();

        return journals.stream()
                .map(journal -> innerverseService.convertToResponse(journal))
                .toList();
    }
    @GetMapping("/journal/{id}")
    public JournalResponse getJournalById(@PathVariable Long id) {

        JournalEntry journalEntry = innerverseService.getJournalById(id);

        return innerverseService.convertToResponse(journalEntry);
    }
    @DeleteMapping("/journal/{id}")
    public void deleteJournal(@PathVariable Long id) {
        innerverseService.deleteJournal(id);
    }
    @PutMapping("/journal/{id}")
    public JournalResponse updateJournal(

            @PathVariable Long id,
            @RequestBody @Valid JournalRequest request) {

        JournalEntry journalEntry =
                innerverseService.updateJournal(id, request);

        return innerverseService.convertToResponse(journalEntry);
    }
    @GetMapping("/journal/mood/{mood}")
    public List<JournalResponse> getJournalsByMood(
            @PathVariable String mood) {

        List<JournalEntry> journals =
                innerverseService.getJournalsByMood(mood);

        return journals.stream()
                .map(journal -> innerverseService.convertToResponse(journal))
                .toList();
    }
    @GetMapping("/journal/stats")
    public Map<String, Long> getMoodStats() {
        return innerverseService.getMoodStats();
    }
}