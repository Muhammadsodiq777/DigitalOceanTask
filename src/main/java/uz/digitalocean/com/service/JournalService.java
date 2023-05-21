package uz.digitalocean.com.service;

import uz.digitalocean.com.dto.JournalDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;

import java.util.List;

public interface JournalService {
    ResponseDataDto<String> createJournal(JournalDto dto);
    ResponseDataDto<JournalDto> getJournalById(Long unvId);
    ResponseDataDto<List<JournalDto>> getAllJournal();
    ResponseDataDto<JournalDto> editJournal(JournalDto dto);
    ResponseDataDto<JournalDto> deleteJournal(Long id);
}
