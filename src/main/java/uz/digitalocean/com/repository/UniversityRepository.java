package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.University;

public interface UniversityRepository extends JpaRepository<University,Long> {
}
