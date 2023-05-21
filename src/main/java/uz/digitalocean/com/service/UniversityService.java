package uz.digitalocean.com.service;

import uz.digitalocean.com.domain.University;
import uz.digitalocean.com.dto.UniversityDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.dto.response.UniversityResponseDto;

import java.util.List;

public interface UniversityService {

    ResponseDataDto<String> createUniversity(UniversityDto dto);

    ResponseDataDto<UniversityResponseDto> getUniversityById(Long unvId);

    ResponseDataDto<List<UniversityResponseDto>> getAllUniversity();

    ResponseDataDto<String> editUniversity(UniversityDto dto);

    ResponseDataDto<String> deleteUniversity(Long id);
}
