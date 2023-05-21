package uz.digitalocean.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.digitalocean.com.dto.UniversityDto;
import uz.digitalocean.com.service.UniversityService;

@RestController
@RequestMapping("/v1/university")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService service;
    @PostMapping("/create")
    public ResponseEntity<?> createUniversity(@RequestBody UniversityDto dto) {
        return ResponseEntity.ok(service.createUniversity(dto));
    }

    @GetMapping("/get/{universityId}")
    public ResponseEntity<?> getUniversityById(@PathVariable(name = "universityId") Long universityId) {
        return new ResponseEntity<>(service.getUniversityById(universityId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllUniversity() {
        return new ResponseEntity<>(service.getAllUniversity(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editUniversity(@RequestBody UniversityDto dto) {
        return new ResponseEntity<>(service.editUniversity(dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{universityId}")
    public ResponseEntity<?> deleteUniversity(@PathVariable(name = "universityId") Long universityId) {
        return new ResponseEntity<>(service.deleteUniversity(universityId), HttpStatus.OK);
    }

}
