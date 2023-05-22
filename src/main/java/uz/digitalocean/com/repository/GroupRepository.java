package uz.digitalocean.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.digitalocean.com.domain.Faculty;
import uz.digitalocean.com.domain.Group;
import uz.digitalocean.com.repository.custom.GroupStudentCustomRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Long>, GroupStudentCustomRepository {

    Optional<Group> findByIdAndIsActive(Long id, Integer isActive);

    List<Group> findAllByIsActive(Integer isActive);

}
