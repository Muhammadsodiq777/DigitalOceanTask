package uz.digitalocean.com.service;

import uz.digitalocean.com.domain.custom.StudentFullInfoDto;
import uz.digitalocean.com.domain.custom.StudentMarksCustomDto;
import uz.digitalocean.com.domain.custom.StudentSubjectsCustomDto;
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

    ResponseDataDto<String> addSubjectToStudent(Long studentId, Long subjectId);
    ResponseDataDto<String> putMarkToStudent(Long studentId, Long markId);

    ResponseDataDto<List<StudentSubjectsCustomDto>> getStudentSubjects(Long studentId);

    ResponseDataDto<List<StudentMarksCustomDto>> getStudentMarksByGroupId(Long groupId);

    ResponseDataDto<List<StudentFullInfoDto>> searchUser(String name);
}
