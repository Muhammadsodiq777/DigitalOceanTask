package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

    Optional<Subject> findByIdAndIsActive(Long id, Integer isActive);

    List<Subject> findAllByIsActive(Integer isActive);

}
