package uz.digitalocean.com.service;

import uz.digitalocean.com.dto.MarksDto;
import uz.digitalocean.com.dto.response.MarksResponseDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;

import java.util.List;

public interface MarksService {
    ResponseDataDto<String> createMarks(MarksDto dto);
    ResponseDataDto<MarksResponseDto> getMarksById(Long unvId);
    ResponseDataDto<List<MarksResponseDto>> getAllMarks();
    ResponseDataDto<String> editMarks(MarksDto dto);
    ResponseDataDto<String> deleteMarks(Long id);
}
