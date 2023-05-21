package uz.digitalocean.com.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.digitalocean.com.domain.Group;
import uz.digitalocean.com.domain.Journal;
import uz.digitalocean.com.domain.JournalSubjects;
import uz.digitalocean.com.dto.JournalDto;
import uz.digitalocean.com.dto.response.GroupResponseDto;
import uz.digitalocean.com.dto.response.JournalResponseDto;
import uz.digitalocean.com.dto.response.ResponseDataDto;
import uz.digitalocean.com.exception.NotFoundCustomException;
import uz.digitalocean.com.repository.GroupRepository;
import uz.digitalocean.com.repository.JournalRepository;
import uz.digitalocean.com.repository.JournalSubjectsRepository;
import uz.digitalocean.com.service.JournalService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {

    private final JournalRepository repository;
    private final GroupRepository groupRepository;
    private final JournalSubjectsRepository subjectsRepository;

    @Override
    public ResponseDataDto<String> createJournal(JournalDto dto) {

        Journal journal = new Journal();
        journal.setName(dto.getName());

        if(!groupRepository.findByIdAndIsActive(dto.getGroupId(), 1).isPresent())
            throw new NotFoundCustomException("Guruh topilmadi");
        journal.setGroupId(dto.getGroupId());

        repository.save(journal);
        return new ResponseDataDto<>(true, 1, "success", "Journal created");
    }

    @Override
    public ResponseDataDto<JournalResponseDto> getJournalById(Long unvId) {
        Optional<Journal> byIdAndIsActive = repository.findByIdAndIsActive(unvId, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Journal journal = byIdAndIsActive.get();

        JournalResponseDto responseDto = JournalResponseDto.builder()
                .id(journal.getId())
                .name(journal.getName())
                .groupId(journal.getGroupId())
                .build();
        return new ResponseDataDto<>(true, 1, "success", responseDto);
    }

    @Override
    public ResponseDataDto<List<JournalResponseDto>> getAllJournal() {
        List<Journal> allByIsActive = repository.findAllByIsActive(1);
        if (allByIsActive.isEmpty())
            return new ResponseDataDto<>(false, -1, "fail", null);

        List<JournalResponseDto> responseList = new ArrayList<>();

        allByIsActive.forEach(r -> {
            JournalResponseDto responseDto = JournalResponseDto.builder()
                    .id(r.getId())
                    .name(r.getName())
                    .groupId(r.getGroupId())
                    .build();
            responseList.add(responseDto);
        });
        return new ResponseDataDto<>(true, 1, "success", responseList);
    }

    @Override
    public ResponseDataDto<String> editJournal(JournalDto dto) {
        Optional<Journal> byIdAndIsActive = repository.findByIdAndIsActive(dto.getId(), 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Journal journal = byIdAndIsActive.get();
        journal.setName(dto.getName());
        journal.setGroupId(dto.getGroupId());
        journal.setUpdatedAt(LocalDateTime.now());

        repository.save(journal);
        return new ResponseDataDto<>(true, 1, "success", "Journal updated");
    }

    @Override
    public ResponseDataDto<String> deleteJournal(Long id) {
        Optional<Journal> byIdAndIsActive = repository.findByIdAndIsActive(id, 1);
        if (!byIdAndIsActive.isPresent())
            return new ResponseDataDto<>(false, -1, "fail", null);

        Journal journal = byIdAndIsActive.get();
        journal.setIsActive(0);

        repository.save(journal);
        return new ResponseDataDto<>(true, 1, "success", "Journal updated");
    }

    public ResponseDataDto<String> addSubjectToJournal(Long subjectId, Long journalId){
        JournalSubjects subjects = new JournalSubjects();
        subjects.setSubjectId(subjectId);
        subjects.setJournalId(journalId);

        subjectsRepository.save(subjects);

        return new ResponseDataDto<>(true, 1, "success", "Subjects are added");
    }
}
