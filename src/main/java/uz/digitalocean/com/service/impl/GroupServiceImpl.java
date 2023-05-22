package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.domain.Faculty;
import uz.digitalocean.com.domain.Group;
import uz.digitalocean.com.domain.custom.GroupStudentCustomDto;
import uz.digitalocean.com.dto.GroupDto;
import uz.digitalocean.com.dto.response.FacultyResponseDto;
import uz.digitalocean.com.dto.response.GroupResponseDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.exception.NotFoundCustomException;
import uz.digitalocean.com.repository.FacultyRepository;
import uz.digitalocean.com.repository.GroupRepository;
import uz.digitalocean.com.service.GroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;
    private final FacultyRepository facultyRepository;

    @Override
    public ResponseDataDto<String> createGroup(GroupDto dto) {

        Group group = new Group();
        group.setName(dto.getName());
        group.setYear(dto.getYear());

        if(!facultyRepository.findByIdAndIsActive(dto.getFacultyId(), 1).isPresent())
            throw new NotFoundCustomException("Fakultet topilmadi");

        group.setFacultyId(dto.getFacultyId());

        repository.save(group);
        return new ResponseDataDto<>(true, 1, "success", "Group is saved");
    }

    @Override
    public ResponseDataDto<GroupResponseDto> getGroupById(Long id) {

        Optional<Group> byIdAndIsActive = repository.findByIdAndIsActive(id, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Group group = byIdAndIsActive.get();

        GroupResponseDto responseDto = GroupResponseDto.builder()
                .id(group.getId())
                .name(group.getName())
                .year(group.getYear())
                .facultyId(group.getFacultyId())
                .build();
        return new ResponseDataDto<>(true, 1, "success", responseDto);
    }

    @Override
    public ResponseDataDto<List<GroupResponseDto>> getAllGroup() {

        List<Group> allByIsActive = repository.findAllByIsActive(1);
        if (allByIsActive.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);

        List<GroupResponseDto> responseList = new ArrayList<>();

        allByIsActive.forEach(r -> {
            GroupResponseDto responseDto = GroupResponseDto.builder()
                    .id(r.getId())
                    .name(r.getName())
                    .year(r.getYear())
                    .facultyId(r.getFacultyId())
                    .build();
            responseList.add(responseDto);
        });
        return new ResponseDataDto<>(true, 1, "success", responseList);
    }

    @Override
    public ResponseDataDto<String> editGroup(GroupDto dto) {
        Optional<Group> byIdAndIsActive = repository.findByIdAndIsActive(dto.getId(), 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Group group = byIdAndIsActive.get();
        group.setName(dto.getName());
        group.setYear(dto.getYear());
        group.setFacultyId(dto.getFacultyId());

        repository.save(group);
        return new ResponseDataDto<>(true, 1, "success", "Group is updated");
    }

    @Override
    public ResponseDataDto<String> deleteGroup(Long id) {
        Optional<Group> byIdAndIsActive = repository.findByIdAndIsActive(id, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Group group = byIdAndIsActive.get();
        group.setIsActive(0);

        repository.save(group);
        return new ResponseDataDto<>(true, 1, "success", "Group is deleted");
    }

    @Override
    public ResponseDataDto<List<GroupStudentCustomDto>> getGroupsWithStudentCount(Long facultyId){
        List<GroupStudentCustomDto> studentCountByFacultyId = repository.getGroupAndStudentCountByFacultyId(facultyId);
        if (studentCountByFacultyId.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);
        return new ResponseDataDto<>(true, 1, "success", studentCountByFacultyId);
    }
}
