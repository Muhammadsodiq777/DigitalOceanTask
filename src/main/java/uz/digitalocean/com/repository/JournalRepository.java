package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.Faculty;

public interface JournalRepository extends JpaRepository<Faculty,Long> {
}
