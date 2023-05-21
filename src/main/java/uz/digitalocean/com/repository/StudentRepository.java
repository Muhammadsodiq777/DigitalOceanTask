package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
