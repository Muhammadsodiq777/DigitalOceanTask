package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.dto.GroupDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.service.GroupService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    @Override
    public ResponseDataDto<String> createGroup(GroupDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<GroupDto> getGroupById(Long unvId) {
        return null;
    }

    @Override
    public ResponseDataDto<List<GroupDto>> getAllGroup() {
        return null;
    }

    @Override
    public ResponseDataDto<GroupDto> editGroup(GroupDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<GroupDto> deleteGroup(Long id) {
        return null;
    }
}
