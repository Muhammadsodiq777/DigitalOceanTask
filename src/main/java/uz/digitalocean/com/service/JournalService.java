package uz.digitalocean.com.service;

import uz.digitalocean.com.dto.JournalDto;
import uz.digitalocean.com.dto.response.JournalResponseDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;

import java.util.List;

public interface JournalService {

    ResponseDataDto<String> createJournal(JournalDto dto);

    ResponseDataDto<JournalResponseDto> getJournalById(Long unvId);

    ResponseDataDto<List<JournalResponseDto>> getAllJournal();

    ResponseDataDto<String> editJournal(JournalDto dto);

    ResponseDataDto<String> deleteJournal(Long id);

    ResponseDataDto<String> addSubjectToJournal(Long subjectId, Long journalId);
}
