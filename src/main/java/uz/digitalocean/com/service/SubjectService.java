package uz.digitalocean.com.service;

import uz.digitalocean.com.dto.SubjectDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;

import java.util.List;

public interface SubjectService {

    ResponseDataDto<String> createSubject(SubjectDto dto);
    ResponseDataDto<SubjectDto> getSubjectById(Long unvId);
    ResponseDataDto<List<SubjectDto>> getAllSubject();
    ResponseDataDto<SubjectDto> editSubject(SubjectDto dto);
    ResponseDataDto<SubjectDto> deleteSubject(Long id);    
}
