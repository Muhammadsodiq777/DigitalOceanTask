package uz.digitalocean.com.repository.custom;

import uz.digitalocean.com.domain.custom.StudentFullInfoDto;
import uz.digitalocean.com.domain.custom.StudentMarksCustomDto;
import uz.digitalocean.com.domain.custom.StudentSubjectsCustomDto;

import java.util.List;

public interface StudentSubjectsCustomRepository {

    List<StudentSubjectsCustomDto> getStudentSubjectByStudentId(Long studentId);

    List<StudentFullInfoDto> searchUserByUserName(String search);

    List<StudentMarksCustomDto> getStudentMarksByGroupId(Long groupId);

}
