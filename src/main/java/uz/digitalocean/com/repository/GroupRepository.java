package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.Faculty;
import uz.digitalocean.com.domain.Group;

public interface GroupRepository extends JpaRepository<Group,Long> {
}
