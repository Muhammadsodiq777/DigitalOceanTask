package uz.digitalocean.com.service;

import uz.digitalocean.com.domain.custom.GroupStudentCustomDto;
import uz.digitalocean.com.dto.GroupDto;
import uz.digitalocean.com.dto.response.GroupResponseDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;

import java.util.List;

public interface GroupService {
    ResponseDataDto<String> createGroup(GroupDto dto);

    ResponseDataDto<GroupResponseDto> getGroupById(Long id);

    ResponseDataDto<List<GroupResponseDto>> getAllGroup();

    ResponseDataDto<String> editGroup(GroupDto dto);

    ResponseDataDto<String> deleteGroup(Long id);

    ResponseDataDto<List<GroupStudentCustomDto>> getGroupsWithStudentCount(Long facultyId);
}
