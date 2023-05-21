package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.Faculty;
import uz.digitalocean.com.domain.Marks;

import java.util.List;
import java.util.Optional;

public interface MarksRepository extends JpaRepository<Marks, Long> {

    Optional<Marks> findByIdAndIsActive(Long id, Integer isActive);

    List<Marks> findAllByIsActive(Integer isActive);

}
