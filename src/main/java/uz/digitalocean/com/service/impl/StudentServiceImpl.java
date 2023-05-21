package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.dto.StudentDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.repository.StudentRepository;
import uz.digitalocean.com.service.StudentService;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public ResponseDataDto<String> createStudent(StudentDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<StudentDto> getStudentById(Long studentId) {

        List<StudentDto> list = Arrays.asList(
                new StudentDto(1L, "name"),
                new StudentDto(2L, "name"),
                new StudentDto(3L, "name")
        );

        StudentDto studentDto = list.stream().filter(r -> studentId.equals(r.getId())).findFirst().orElse(new StudentDto());

        return new ResponseDataDto<>(true, 1, "success", studentDto) ;
    }

    @Override
    public ResponseDataDto<List<StudentDto>> getAllStudent() {
        return null;
    }

    @Override
    public ResponseDataDto<StudentDto> editStudent(StudentDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<StudentDto> deleteStudent(Long id) {
        return null;
    }
}
