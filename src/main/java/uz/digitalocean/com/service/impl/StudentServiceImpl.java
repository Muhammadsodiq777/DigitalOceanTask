package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.domain.Student;
import uz.digitalocean.com.domain.StudentMarks;
import uz.digitalocean.com.domain.StudentSubjects;
import uz.digitalocean.com.domain.custom.StudentFullInfoDto;
import uz.digitalocean.com.domain.custom.StudentMarksCustomDto;
import uz.digitalocean.com.domain.custom.StudentSubjectsCustomDto;
import uz.digitalocean.com.dto.StudentDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.dto.response.StudentResponseDto;
import uz.digitalocean.com.exception.NotFoundCustomException;
import uz.digitalocean.com.repository.GroupRepository;
import uz.digitalocean.com.repository.StudentMarksRepository;
import uz.digitalocean.com.repository.StudentRepository;
import uz.digitalocean.com.repository.StudentSubjectsRepository;
import uz.digitalocean.com.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final GroupRepository groupRepository;
    private final StudentSubjectsRepository studentSubjectsRepository;
    private final StudentMarksRepository studentMarksRepository;

    @Override
    public ResponseDataDto<String> createStudent(StudentDto dto) {
        Student student = new Student();
        student.setName(dto.getName());

        if (!groupRepository.findByIdAndIsActive(dto.getGroupId(), 1).isPresent())
            throw new NotFoundCustomException("Guruh topilmadi");

        student.setGroupId(dto.getId());

        repository.save(student);
        return new ResponseDataDto<>(true, 1, "success", "Student is added");
    }

    @Override
    public ResponseDataDto<StudentResponseDto> getStudentById(Long studentId) {

        Optional<Student> byIdAndIsActive = repository.findByIdAndIsActive(studentId, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Student student = byIdAndIsActive.get();

        StudentResponseDto responseDto = StudentResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .groupId(student.getGroupId())
                .build();

        return new ResponseDataDto<>(true, 1, "success", responseDto);
    }

    @Override
    public ResponseDataDto<List<StudentResponseDto>> getAllStudent() {

        List<Student> allByIsActive = repository.findAllByIsActive(1);
        if (allByIsActive.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);

        List<StudentResponseDto> responseList = new ArrayList<>();

        allByIsActive.forEach(r -> {
            StudentResponseDto responseDto = StudentResponseDto.builder()
                    .id(r.getId())
                    .name(r.getName())
                    .groupId(r.getGroupId())
                    .build();
            responseList.add(responseDto);
        });
        return new ResponseDataDto<>(true, 1, "success", responseList);
    }

    @Override
    public ResponseDataDto<String> editStudent(StudentDto dto) {

        Optional<Student> byIdAndIsActive = repository.findByIdAndIsActive(dto.getGroupId(), 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Student student = byIdAndIsActive.get();
        student.setName(dto.getName());
        student.setGroupId(dto.getId());

        repository.save(student);
        return new ResponseDataDto<>(true, 1, "success", "Student is updated");
    }

    @Override
    public ResponseDataDto<String> deleteStudent(Long id) {

        Optional<Student> byIdAndIsActive = repository.findByIdAndIsActive(id, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Student student = byIdAndIsActive.get();
        student.setIsActive(0);

        repository.save(student);
        return new ResponseDataDto<>(true, 1, "success", "Student is deleted");
    }

    @Override
    public ResponseDataDto<String> addSubjectToStudent(Long studentId, Long subjectId) {
        StudentSubjects studentSubjects = new StudentSubjects();
        studentSubjects.setStudentId(studentId);
        studentSubjects.setSubjectId(subjectId);
        studentSubjectsRepository.save(studentSubjects);

        return new ResponseDataDto<>(true, 1, "success", "Fan talabaga biriktirildi");
    }

    @Override
    public ResponseDataDto<String> putMarkToStudent(Long studentId, Long markId) {
        StudentMarks studentMarks = new StudentMarks();
        studentMarks.setStudentId(studentId);
        studentMarks.setMarkId(markId);

        studentMarksRepository.save(studentMarks);

        return new ResponseDataDto<>(true, 1, "success", "Talaba baholandi");
    }

    @Override
    public ResponseDataDto<List<StudentSubjectsCustomDto>> getStudentSubjects(Long studentId) {
        List<StudentSubjectsCustomDto> studentSubjectByStudentId = repository.getStudentSubjectByStudentId(studentId);
        if (studentSubjectByStudentId.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);
        return new ResponseDataDto<>(true, 1, "success", studentSubjectByStudentId);
    }

    @Override
    public ResponseDataDto<List<StudentMarksCustomDto>> getStudentMarksByGroupId(Long groupId) {
        List<StudentMarksCustomDto> studentMarksByGroupId = repository.getStudentMarksByGroupId(groupId);
        if (studentMarksByGroupId.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);
        return new ResponseDataDto<>(true, 1, "success", studentMarksByGroupId);
    }

    @Override
    public ResponseDataDto<List<StudentFullInfoDto>> searchUser(String name) {
        List<StudentFullInfoDto> studentFullInfoDtos = repository.searchUserByUserName(name);
        if (studentFullInfoDtos.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);
        return new ResponseDataDto<>(true, 1, "success", studentFullInfoDtos);
    }
}
