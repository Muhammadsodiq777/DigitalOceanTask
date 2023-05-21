package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.dto.UniversityDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.service.UniversityService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    @Override
    public ResponseDataDto<String> createUniversity(UniversityDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<UniversityDto> getUniversityById(Long unvId) {
        return null;
    }

    @Override
    public ResponseDataDto<List<UniversityDto>> getAllUniversity() {
        return null;
    }

    @Override
    public ResponseDataDto<UniversityDto> editUniversity(UniversityDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<UniversityDto> deleteUniversity(Long id) {
        return null;
    }
}
