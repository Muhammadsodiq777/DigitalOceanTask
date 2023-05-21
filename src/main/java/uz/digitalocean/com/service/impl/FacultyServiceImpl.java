package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.domain.Faculty;
import uz.digitalocean.com.dto.FacultyDto;
import uz.digitalocean.com.dto.response.FacultyResponseDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.exception.NotFoundCustomException;
import uz.digitalocean.com.repository.FacultyRepository;
import uz.digitalocean.com.repository.UniversityRepository;
import uz.digitalocean.com.service.FacultyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository repository;
    private final UniversityRepository universityRepository;

    @Override
    public ResponseDataDto<String> createFaculty(FacultyDto dto) {

        Faculty faculty = new Faculty();
        faculty.setName(dto.getName());

        if (!universityRepository.findByIdAndIsActive(dto.getUniversityId(), 1).isPresent())
            throw new NotFoundCustomException("Universityet topilmadi");

        faculty.setUniversityId(dto.getUniversityId());

        repository.save(faculty);

        return new ResponseDataDto<>(true, 1, "success", "Faculty is saved");
    }

    @Override
    public ResponseDataDto<FacultyResponseDto> getFacultyById(Long fId) {
        Optional<Faculty> byIdAndIsActive = repository.findByIdAndIsActive(fId, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Faculty faculty = byIdAndIsActive.get();

        FacultyResponseDto responseDto = FacultyResponseDto.builder()
                .id(faculty.getId())
                .name(faculty.getName())
                .universityId(faculty.getUniversityId())
                .build();
        return new ResponseDataDto<>(true, 1, "success", responseDto);

    }

    @Override
    public ResponseDataDto<List<FacultyResponseDto>> getAllFaculty() {

        List<Faculty> allByIsActive = repository.findAllByIsActive(1);
        if (allByIsActive.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);

        List<FacultyResponseDto> responseList = new ArrayList<>();

        allByIsActive.forEach(r -> {
            FacultyResponseDto response = FacultyResponseDto.builder()
                    .id(r.getId())
                    .name(r.getName())
                    .universityId(r.getUniversityId())
                    .build();
            responseList.add(response);
        });
        return new ResponseDataDto<>(true, 1, "success", responseList);
    }

    @Override
    public ResponseDataDto<String> editFaculty(FacultyDto dto) {
        Optional<Faculty> byIdAndIsActive = repository.findByIdAndIsActive(dto.getId(), 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Faculty faculty = byIdAndIsActive.get();
        faculty.setName(dto.getName());
        faculty.setUniversityId(dto.getUniversityId());

        repository.save(faculty);

        return new ResponseDataDto<>(true, 1, "success", "Faculty is edited");
    }

    @Override
    public ResponseDataDto<String> deleteFaculty(Long id) {
        Optional<Faculty> byIdAndIsActive = repository.findByIdAndIsActive(id, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Faculty faculty = byIdAndIsActive.get();
        faculty.setIsActive(0);

        repository.save(faculty);

        return new ResponseDataDto<>(true, 1, "success", "Faculty is deleted");
    }
}
