package uz.digitalocean.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.digitalocean.com.dto.SubjectDto;
import uz.digitalocean.com.service.SubjectService;

@RestController
@RequestMapping("/v1/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService service;
    @PostMapping("/create")
    public ResponseEntity<?> createSubject(@RequestBody SubjectDto dto) {
        return ResponseEntity.ok(service.createSubject(dto));
    }

    @GetMapping("/get/{subjectId}")
    public ResponseEntity<?> getSubjectById(@PathVariable(name = "subjectId") Long subjectId) {
        return new ResponseEntity<>(service.getSubjectById(subjectId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllSubject() {
        return new ResponseEntity<>(service.getAllSubject(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editSubject(@RequestBody SubjectDto dto) {
        return new ResponseEntity<>(service.editSubject(dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{subjectId}")
    public ResponseEntity<?> deleteSubject(@PathVariable(name = "subjectId") Long subjectId) {
        return new ResponseEntity<>(service.deleteSubject(subjectId), HttpStatus.OK);
    }
    
}
