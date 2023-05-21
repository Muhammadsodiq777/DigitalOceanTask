package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.domain.Journal;
import uz.digitalocean.com.domain.Marks;
import uz.digitalocean.com.dto.MarksDto;
import uz.digitalocean.com.dto.response.JournalResponseDto;
import uz.digitalocean.com.dto.response.MarksResponseDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.repository.MarksRepository;
import uz.digitalocean.com.service.MarksService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarksServiceImpl implements MarksService {

    private final MarksRepository repository;

    @Override
    public ResponseDataDto<String> createMarks(MarksDto dto) {

        Marks marks = new Marks();
        marks.setName(dto.getName());

        repository.save(marks);
        return new ResponseDataDto<>(true, 1, "success", "Mark is created");
    }

    @Override
    public ResponseDataDto<MarksResponseDto> getMarksById(Long unvId) {

        Optional<Marks> byIdAndIsActive = repository.findByIdAndIsActive(unvId, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Marks marks = byIdAndIsActive.get();

        MarksResponseDto responseDto = MarksResponseDto.builder()
                .id(marks.getId())
                .name(marks.getName()).build();
        return new ResponseDataDto<>(true, 1, "success", responseDto);
    }

    @Override
    public ResponseDataDto<List<MarksResponseDto>> getAllMarks() {
        List<Marks> allByIsActive = repository.findAllByIsActive(1);
        if (allByIsActive.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);

        List<MarksResponseDto> responseList = new ArrayList<>();

        allByIsActive.forEach(r -> {
            MarksResponseDto responseDto = MarksResponseDto.builder()
                    .id(r.getId())
                    .name(r.getName()).build();
            responseList.add(responseDto);
        });
        return new ResponseDataDto<>(true, 1, "success", responseList);
    }

    @Override
    public ResponseDataDto<String> editMarks(MarksDto dto) {
        Optional<Marks> byIdAndIsActive = repository.findByIdAndIsActive(dto.getId(), 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Marks marks = byIdAndIsActive.get();
        marks.setName(dto.getName());

        repository.save(marks);
        return new ResponseDataDto<>(true, 1, "success", "Mark is updated");
    }

    @Override
    public ResponseDataDto<String> deleteMarks(Long id) {
        Optional<Marks> byIdAndIsActive = repository.findByIdAndIsActive(id, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Marks marks = byIdAndIsActive.get();
        marks.setIsActive(0);

        repository.save(marks);
        return new ResponseDataDto<>(true, 1, "success", "Mark is updated");
    }
}
