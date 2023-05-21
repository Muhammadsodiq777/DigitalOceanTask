package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.Faculty;
import uz.digitalocean.com.domain.Journal;

import java.util.List;
import java.util.Optional;

public interface JournalRepository extends JpaRepository<Journal,Long> {

    Optional<Journal> findByIdAndIsActive(Long id, Integer isActive);

    List<Journal> findAllByIsActive(Integer isActive);

}
