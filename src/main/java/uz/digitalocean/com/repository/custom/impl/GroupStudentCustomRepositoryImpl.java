package uz.digitalocean.com.repository.custom.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import uz.digitalocean.com.domain.custom.GroupStudentCustomDto;
import uz.digitalocean.com.domain.custom.StudentSubjectsCustomDto;
import uz.digitalocean.com.repository.custom.GroupStudentCustomRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupStudentCustomRepositoryImpl implements GroupStudentCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<GroupStudentCustomDto> getGroupAndStudentCountByFacultyId(Long facultyId) {

        String query = "select ug.name as groupName,\n" +
                "       (select count(st.id)\n" +
                "        from student st\n" +
                "        where st.group_id = ug.id\n" +
                "          and st.is_active = 1) as studentNumber\n" +
                "from faculty f\n" +
                "         inner join unv_group ug on f.id = ug.faculty_id\n" +
                "where f.id = :facultyId\n" +
                "  and f.is_active = 1\n" +
                "  and ug.is_active = 1";
        try {
            Query nativeQuery = entityManager.createNativeQuery(query, GroupStudentCustomDto.class)
                    .setParameter("facultyId", facultyId);

            List<GroupStudentCustomDto> list = nativeQuery.getResultList();
            return list;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
