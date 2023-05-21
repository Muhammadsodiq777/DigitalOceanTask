package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.JournalSubjects;

public interface JournalSubjectsRepository extends JpaRepository<JournalSubjects, Long> {
}
