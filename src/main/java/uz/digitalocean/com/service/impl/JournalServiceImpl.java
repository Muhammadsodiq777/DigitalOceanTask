package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.dto.JournalDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.service.JournalService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {
    @Override
    public ResponseDataDto<String> createJournal(JournalDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<JournalDto> getJournalById(Long unvId) {
        return null;
    }

    @Override
    public ResponseDataDto<List<JournalDto>> getAllJournal() {
        return null;
    }

    @Override
    public ResponseDataDto<JournalDto> editJournal(JournalDto dto) {
        return null;
    }

    @Override
    public ResponseDataDto<JournalDto> deleteJournal(Long id) {
        return null;
    }
}
