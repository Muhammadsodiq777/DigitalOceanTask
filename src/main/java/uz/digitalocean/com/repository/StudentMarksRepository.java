package uz.digitalocean.com.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.StudentMarks;
import uz.digitalocean.com.domain.base.BaseEntity;

public interface StudentMarksRepository extends JpaRepository<StudentMarks,Long> {
}




