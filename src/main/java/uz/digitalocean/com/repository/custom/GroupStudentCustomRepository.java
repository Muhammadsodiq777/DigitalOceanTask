package uz.digitalocean.com.repository.custom;

import uz.digitalocean.com.domain.custom.GroupStudentCustomDto;

import java.util.List;

public interface GroupStudentCustomRepository {

    List<GroupStudentCustomDto> getGroupAndStudentCountByFacultyId(Long facultyId);

}
