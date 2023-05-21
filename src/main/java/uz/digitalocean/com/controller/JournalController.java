package uz.digitalocean.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.digitalocean.com.dto.JournalDto;
import uz.digitalocean.com.service.JournalService;

@RestController
@RequestMapping("/v1/journal")
@RequiredArgsConstructor
public class JournalController {

    private final JournalService service;
    @PostMapping("/create")
    public ResponseEntity<?> createJournal(@RequestBody JournalDto dto) {
        return ResponseEntity.ok(service.createJournal(dto));
    }

    @GetMapping("/get/{journalId}")
    public ResponseEntity<?> getJournalById(@PathVariable(name = "journalId") Long journalId) {
        return new ResponseEntity<>(service.getJournalById(journalId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllJournal() {
        return new ResponseEntity<>(service.getAllJournal(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editJournal(@RequestBody JournalDto dto) {
        return new ResponseEntity<>(service.editJournal(dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{journalId}")
    public ResponseEntity<?> deleteJournal(@PathVariable(name = "journalId") Long journalId) {
        return new ResponseEntity<>(service.deleteJournal(journalId), HttpStatus.OK);
    }

    @PostMapping("/add/subject-to-journal")
    public ResponseEntity<?> deleteJournal(@RequestParam Long subjectId, @RequestParam Long journalId) {
        return new ResponseEntity<>(service.addSubjectToJournal(subjectId, journalId), HttpStatus.OK);
    }
    
}
