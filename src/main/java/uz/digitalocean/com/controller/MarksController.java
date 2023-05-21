package uz.digitalocean.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.digitalocean.com.dto.MarksDto;
import uz.digitalocean.com.service.MarksService;

@RestController
@RequestMapping("/v1/marks")
@RequiredArgsConstructor
public class MarksController {
    
    private final MarksService service;
    @PostMapping("/create")
    public ResponseEntity<?> createMarks(@RequestBody MarksDto dto) {
        return ResponseEntity.ok(service.createMarks(dto));
    }

    @GetMapping("/get/{marksId}")
    public ResponseEntity<?> getMarksById(@PathVariable(name = "marksId") Long marksId) {
        return new ResponseEntity<>(service.getMarksById(marksId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllMarks() {
        return new ResponseEntity<>(service.getAllMarks(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editMarks(@RequestBody MarksDto dto) {
        return new ResponseEntity<>(service.editMarks(dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{marksId}")
    public ResponseEntity<?> deleteMarks(@PathVariable(name = "marksId") Long marksId) {
        return new ResponseEntity<>(service.deleteMarks(marksId), HttpStatus.OK);
    }
}
