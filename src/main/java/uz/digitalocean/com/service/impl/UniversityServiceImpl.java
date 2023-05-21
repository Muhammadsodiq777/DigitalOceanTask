package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.domain.University;
import uz.digitalocean.com.dto.UniversityDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.dto.response.UniversityResponseDto;
import uz.digitalocean.com.repository.UniversityRepository;
import uz.digitalocean.com.service.UniversityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository repository;

    @Override
    public ResponseDataDto<String> createUniversity(UniversityDto dto) {

        University university = new University();
        university.setName(dto.getName());
        university.setAddress(dto.getAddress());

        repository.save(university);

        return new ResponseDataDto<>(true, 1, "success", "Universitet saqlandi");
    }

    @Override
    public ResponseDataDto<UniversityResponseDto> getUniversityById(Long unvId) {
        Optional<University> idAndIsActive = repository.findByIdAndIsActive(unvId, 1);
        if (!idAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);
        University university = idAndIsActive.get();

        UniversityResponseDto response = UniversityResponseDto.builder()
                .id(university.getId())
                .name(university.getName())
                .address(university.getAddress())
                .build();

        return new ResponseDataDto<>(true, 1, "success", response);
    }

    @Override
    public ResponseDataDto<List<UniversityResponseDto>> getAllUniversity() {
        List<University> allByIsActive = repository.findAllByIsActive(1);
        if (allByIsActive.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);

        List<UniversityResponseDto> responseList = new ArrayList<>();

        allByIsActive.forEach(r -> {
            UniversityResponseDto response = UniversityResponseDto.builder()
                    .id(r.getId())
                    .name(r.getName())
                    .address(r.getAddress())
                    .build();
            responseList.add(response);
        });
        return new ResponseDataDto<>(true, 1, "success", responseList);
    }

    @Override
    public ResponseDataDto<String> editUniversity(UniversityDto dto) {

        Optional<University> idAndIsActive = repository.findByIdAndIsActive(dto.getId(), 1);
        if (idAndIsActive.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);

        University university = idAndIsActive.get();
        university.setName(dto.getName());
        university.setAddress(dto.getAddress());

        repository.save(university);

        return new ResponseDataDto<>(true, 1, "success", "University edited");
    }

    @Override
    public ResponseDataDto<String> deleteUniversity(Long id) {
        Optional<University> idAndIsActive = repository.findByIdAndIsActive(id, 1);
        if (idAndIsActive.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);

        University university = idAndIsActive.get();
        university.setIsActive(0);

        repository.save(university);

        return new ResponseDataDto<>(true, 1, "success", "University is deleted");
    }
}
