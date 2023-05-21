package uz.digitalocean.com.service;

import uz.digitalocean.com.dto.FacultyDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;

import java.util.List;

public interface FacultyService {
    ResponseDataDto<String> createFaculty(FacultyDto dto);
    ResponseDataDto<FacultyDto> getFacultyById(Long unvId);
    ResponseDataDto<List<FacultyDto>> getAllFaculty();
    ResponseDataDto<FacultyDto> editFaculty(FacultyDto dto);
    ResponseDataDto<FacultyDto> deleteFaculty(Long id);
}
