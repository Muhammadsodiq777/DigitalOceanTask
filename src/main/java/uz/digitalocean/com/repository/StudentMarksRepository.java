package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.StudentMarks;

public interface StudentMarksRepository extends JpaRepository<StudentMarks, Long> {
}




