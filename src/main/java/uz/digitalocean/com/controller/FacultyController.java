package uz.digitalocean.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.digitalocean.com.dto.FacultyDto;
import uz.digitalocean.com.service.FacultyService;

@RestController
@RequestMapping("/v1/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService service;
    @PostMapping("/create")
    public ResponseEntity<?> createFaculty(@RequestBody FacultyDto dto) {
        return ResponseEntity.ok(service.createFaculty(dto));
    }

    @GetMapping("/get/{facultyId}")
    public ResponseEntity<?> getFacultyById(@PathVariable(name = "facultyId") Long facultyId) {
        return new ResponseEntity<>(service.getFacultyById(facultyId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllFaculty() {
        return new ResponseEntity<>(service.getAllFaculty(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editFaculty(@RequestBody FacultyDto dto) {
        return new ResponseEntity<>(service.editFaculty(dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{facultyId}")
    public ResponseEntity<?> deleteFaculty(@PathVariable(name = "facultyId") Long facultyId) {
        return new ResponseEntity<>(service.deleteFaculty(facultyId), HttpStatus.OK);
    }
    
}
