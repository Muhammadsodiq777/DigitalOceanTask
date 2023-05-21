package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.dto.FacultyDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.service.FacultyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {
    @Override
    public ResponseDataDto<String> createFaculty(FacultyDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<FacultyDto> getFacultyById(Long unvId) {
        return null;
    }

    @Override
    public ResponseDataDto<List<FacultyDto>> getAllFaculty() {
        return null;
    }

    @Override
    public ResponseDataDto<FacultyDto> editFaculty(FacultyDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<FacultyDto> deleteFaculty(Long id) {
        return null;
    }
}
