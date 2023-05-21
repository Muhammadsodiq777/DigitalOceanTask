package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.Faculty;
import uz.digitalocean.com.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
