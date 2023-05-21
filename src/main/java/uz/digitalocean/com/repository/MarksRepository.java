package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.Marks;

public interface MarksRepository extends JpaRepository<Marks, Long> {
}
