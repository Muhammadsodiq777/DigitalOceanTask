package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.Student;
import uz.digitalocean.com.repository.custom.StudentSubjectsCustomRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>, StudentSubjectsCustomRepository {

    Optional<Student> findByIdAndIsActive(Long id, Integer isActive);

    List<Student> findAllByIsActive(Integer isActive);

    Optional<Student> findByUsername(String name);

}
