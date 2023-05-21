package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.dto.MarksDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.service.MarksService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarksServiceImpl implements MarksService {
    @Override
    public ResponseDataDto<String> createMarks(MarksDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<MarksDto> getMarksById(Long unvId) {
        return null;
    }

    @Override
    public ResponseDataDto<List<MarksDto>> getAllMarks() {
        return null;
    }

    @Override
    public ResponseDataDto<MarksDto> editMarks(MarksDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<MarksDto> deleteMarks(Long id) {
        return null;
    }
}
