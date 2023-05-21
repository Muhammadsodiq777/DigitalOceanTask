package uz.digitalocean.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.digitalocean.com.dto.StudentDto;
import uz.digitalocean.com.service.StudentService;

@RestController
@RequestMapping("/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;
    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody StudentDto dto) {
        return ResponseEntity.ok(service.createStudent(dto));
    }

    @GetMapping("/get/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "studentId") Long studentId) {
        return new ResponseEntity<>(service.getStudentById(studentId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllStudent() {
        return new ResponseEntity<>(service.getAllStudent(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editStudent(@RequestBody StudentDto dto) {
        return new ResponseEntity<>(service.editStudent(dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "studentId") Long studentId) {
        return new ResponseEntity<>(service.deleteStudent(studentId), HttpStatus.OK);
    }
}
