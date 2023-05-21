package uz.digitalocean.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.digitalocean.com.dto.GroupDto;
import uz.digitalocean.com.service.GroupService;

@RestController
@RequestMapping("/v1/group")
@RequiredArgsConstructor
public class GroupController {
    
    private final GroupService service;
    @PostMapping("/create")
    public ResponseEntity<?> createGroup(@RequestBody GroupDto dto) {
        return ResponseEntity.ok(service.createGroup(dto));
    }

    @GetMapping("/get/{groupId}")
    public ResponseEntity<?> getGroupById(@PathVariable(name = "groupId") Long groupId) {
        return new ResponseEntity<>(service.getGroupById(groupId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllGroup() {
        return new ResponseEntity<>(service.getAllGroup(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editGroup(@RequestBody GroupDto dto) {
        return new ResponseEntity<>(service.editGroup(dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{groupId}")
    public ResponseEntity<?> deleteGroup(@PathVariable(name = "groupId") Long groupId) {
        return new ResponseEntity<>(service.deleteGroup(groupId), HttpStatus.OK);
    }
}
