package uz.digitalocean.com.service;

import uz.digitalocean.com.dto.StudentDto;
import uz.digitalocean.com.dto.StudentDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;

import java.util.List;

public interface StudentService {

    ResponseDataDto<String> createStudent(StudentDto dto);

    ResponseDataDto<StudentDto> getStudentById(Long studentId);
    
    ResponseDataDto<List<StudentDto>> getAllStudent();
    ResponseDataDto<StudentDto> editStudent(StudentDto dto);
    ResponseDataDto<StudentDto> deleteStudent(Long id);
}
