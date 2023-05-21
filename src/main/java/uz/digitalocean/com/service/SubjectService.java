package uz.digitalocean.com.service;

import uz.digitalocean.com.dto.SubjectDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.dto.response.SubjectResponseDto;

import java.util.List;

public interface SubjectService {

    ResponseDataDto<String> createSubject(SubjectDto dto);
    ResponseDataDto<SubjectResponseDto> getSubjectById(Long unvId);
    ResponseDataDto<List<SubjectResponseDto>> getAllSubject();
    ResponseDataDto<String> editSubject(SubjectDto dto);
    ResponseDataDto<String> deleteSubject(Long id);
}
