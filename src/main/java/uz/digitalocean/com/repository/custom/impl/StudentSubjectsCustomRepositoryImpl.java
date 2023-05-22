package uz.digitalocean.com.repository.custom.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import uz.digitalocean.com.domain.custom.StudentFullInfoDto;
import uz.digitalocean.com.domain.custom.StudentMarksCustomDto;
import uz.digitalocean.com.domain.custom.StudentSubjectsCustomDto;
import uz.digitalocean.com.repository.custom.StudentSubjectsCustomRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentSubjectsCustomRepositoryImpl implements StudentSubjectsCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<StudentSubjectsCustomDto> getStudentSubjectByStudentId(Long studentId) {

        String query = "select  s.name as subjectName\n" +
                "from student st\n" +
                "         inner join student_subjects ss on st.id = ss.student_id\n" +
                "         inner join subject s on ss.subject_id = s.id\n" +
                "where st.id = :studentId\n" +
                "  and st.is_active = 1\n" +
                "  and ss.is_active = 1\n" +
                "  and s.is_active = 1";

        try {
            Query nativeQuery = entityManager.createNativeQuery(query, StudentSubjectsCustomDto.class);
            nativeQuery.setParameter("studentId", studentId);

            List<StudentSubjectsCustomDto> list = nativeQuery.getResultList();
            return list;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<StudentFullInfoDto> searchUserByUserName(String search) {
        String query = "select st.name as studentName,\n" +
                "       f.name as facultyName,\n" +
                "       ug.name as groupName\n" +
                "from student st\n" +
                "         inner join unv_group ug on st.group_id = ug.id\n" +
                "         inner join faculty f on f.id = ug.faculty_id\n" +
                "where st.is_active = 1\n" +
                "    and st.name like '%" + search + "%'";

        try {
            Query nativeQuery = entityManager.createNativeQuery(query, StudentFullInfoDto.class);

            List<StudentFullInfoDto> list = nativeQuery.getResultList();
            return list;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<StudentMarksCustomDto> getStudentMarksByGroupId(Long groupId) {
        String query = "select s.name as studentName,\n" +
                "       m.name as marks\n" +
                "from unv_group ug\n" +
                "         inner join student s on ug.id = s.group_id\n" +
                "         inner join student_marks sm on s.id = sm.student_id\n" +
                "         inner join marks m on m.id = sm.marks_id\n" +
                "where ug.id = 1\n" +
                "order by m.name desc";

        try {
            Query nativeQuery = entityManager.createNativeQuery(query, StudentMarksCustomDto.class);

            List<StudentMarksCustomDto> list = nativeQuery.getResultList();
            return list;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
