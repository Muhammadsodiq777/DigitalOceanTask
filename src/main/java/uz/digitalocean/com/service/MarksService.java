package uz.digitalocean.com.service;

import uz.digitalocean.com.dto.MarksDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;

import java.util.List;

public interface MarksService {
    ResponseDataDto<String> createMarks(MarksDto dto);
    ResponseDataDto<MarksDto> getMarksById(Long unvId);
    ResponseDataDto<List<MarksDto>> getAllMarks();
    ResponseDataDto<MarksDto> editMarks(MarksDto dto);
    ResponseDataDto<MarksDto> deleteMarks(Long id);
}
