package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.dto.SubjectDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.service.SubjectService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    @Override
    public ResponseDataDto<String> createSubject(SubjectDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<SubjectDto> getSubjectById(Long unvId) {
        return null;
    }

    @Override
    public ResponseDataDto<List<SubjectDto>> getAllSubject() {
        return null;
    }

    @Override
    public ResponseDataDto<SubjectDto> editSubject(SubjectDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<SubjectDto> deleteSubject(Long id) {
        return null;
    }
}
