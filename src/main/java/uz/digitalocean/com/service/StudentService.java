package uz.digitalocean.com.service;

import uz.digitalocean.com.dto.StudentDto;
import uz.digitalocean.com.dto.StudentDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.dto.response.StudentResponseDto;

import java.util.List;

public interface StudentService {

    ResponseDataDto<String> createStudent(StudentDto dto);

    ResponseDataDto<StudentResponseDto> getStudentById(Long studentId);
    
    ResponseDataDto<List<StudentResponseDto>> getAllStudent();
    ResponseDataDto<String> editStudent(StudentDto dto);
    ResponseDataDto<String> deleteStudent(Long id);
}
