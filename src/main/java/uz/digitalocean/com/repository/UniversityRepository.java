package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.University;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University,Long> {

    Optional<University> findByIdAndIsActive(Long id, Integer isActive);

    List<University> findAllByIsActive(Integer isActive);

}
