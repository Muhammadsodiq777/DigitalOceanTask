package uz.digitalocean.com.service;

import uz.digitalocean.com.domain.University;
import uz.digitalocean.com.dto.UniversityDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;

import java.util.List;

public interface UniversityService {
    ResponseDataDto<String> createUniversity(UniversityDto dto);
    ResponseDataDto<UniversityDto> getUniversityById(Long unvId);
    ResponseDataDto<List<UniversityDto>> getAllUniversity();
    ResponseDataDto<UniversityDto> editUniversity(UniversityDto dto);
    ResponseDataDto<UniversityDto> deleteUniversity(Long id);
}
