package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.domain.Student;
import uz.digitalocean.com.domain.Subject;
import uz.digitalocean.com.dto.SubjectDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.dto.response.StudentResponseDto;
import uz.digitalocean.com.dto.response.SubjectResponseDto;
import uz.digitalocean.com.repository.SubjectRepository;
import uz.digitalocean.com.service.SubjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository repository;

    @Override
    public ResponseDataDto<String> createSubject(SubjectDto dto) {

        Subject subject = new Subject();
        subject.setName(dto.getName());

        repository.save(subject);

        return new ResponseDataDto<>(true, 1, "success", "Subject is created");
    }

    @Override
    public ResponseDataDto<SubjectResponseDto> getSubjectById(Long subjectId) {

        Optional<Subject> byIdAndIsActive = repository.findByIdAndIsActive(subjectId, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Subject subject = byIdAndIsActive.get();

        SubjectResponseDto responseDto = SubjectResponseDto.builder()
                .id(subject.getId())
                .name(subject.getName())
                .build();

        return new ResponseDataDto<>(true, 1, "success", responseDto);
    }

    @Override
    public ResponseDataDto<List<SubjectResponseDto>> getAllSubject() {

        List<Subject> allByIsActive = repository.findAllByIsActive(1);
        if (allByIsActive.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);

        List<SubjectResponseDto> responseList = new ArrayList<>();

        allByIsActive.forEach(r -> {
            SubjectResponseDto responseDto = SubjectResponseDto.builder()
                    .id(r.getId())
                    .name(r.getName())
                    .build();
            responseList.add(responseDto);
        });
        return new ResponseDataDto<>(true, 1, "success", responseList);
    }

    @Override
    public ResponseDataDto<String> editSubject(SubjectDto dto) {
        Optional<Subject> byIdAndIsActive = repository.findByIdAndIsActive(dto.getId(), 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Subject subject = byIdAndIsActive.get();
        subject.setName(dto.getName());

        repository.save(subject);

        return new ResponseDataDto<>(true, 1, "success", "Subject is updated");
    }

    @Override
    public ResponseDataDto<String> deleteSubject(Long id) {
        Optional<Subject> byIdAndIsActive = repository.findByIdAndIsActive(id, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Subject subject = byIdAndIsActive.get();
        subject.setIsActive(0);
        repository.save(subject);

        return new ResponseDataDto<>(true, 1, "success", "Subject is updated");
    }
}
