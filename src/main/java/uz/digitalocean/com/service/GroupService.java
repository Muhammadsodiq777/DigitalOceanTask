package uz.digitalocean.com.service;

import uz.digitalocean.com.dto.GroupDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;

import java.util.List;

public interface GroupService {
    ResponseDataDto<String> createGroup(GroupDto dto);
    ResponseDataDto<GroupDto> getGroupById(Long unvId);
    ResponseDataDto<List<GroupDto>> getAllGroup();
    ResponseDataDto<GroupDto> editGroup(GroupDto dto);
    ResponseDataDto<GroupDto> deleteGroup(Long id);
}
