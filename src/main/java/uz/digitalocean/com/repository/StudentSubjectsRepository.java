package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.StudentSubjects;
import uz.digitalocean.com.domain.base.BaseEntity;

public interface StudentSubjectsRepository extends JpaRepository<StudentSubjects,Long> {
}




