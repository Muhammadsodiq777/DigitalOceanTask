package uz.digitalocean.com.service;

import uz.digitalocean.com.dto.FacultyDto;
import uz.digitalocean.com.dto.response.FacultyResponseDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;

import java.util.List;

public interface FacultyService {
    ResponseDataDto<String> createFaculty(FacultyDto dto);
    ResponseDataDto<FacultyResponseDto> getFacultyById(Long fId);
    ResponseDataDto<List<FacultyResponseDto>> getAllFaculty();
    ResponseDataDto<String> editFaculty(FacultyDto dto);
    ResponseDataDto<String> deleteFaculty(Long id);
}
