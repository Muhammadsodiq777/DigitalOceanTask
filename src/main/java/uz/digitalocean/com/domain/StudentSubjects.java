package uz.digitalocean.com.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.digitalocean.com.domain.base.BaseEntity;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT", indexes = {@Index(name = "uniqueIndex", columnList = "ID", unique = true)})
public class StudentSubjects extends BaseEntity<String> {

    @Column(name = "SUBJECT_ID", nullable = false)
    private Long subjectId;

    @Column(name = "STUDENT_ID", nullable = false)
    private Long studentId;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Integer isActive; // 1 active | 0 not active
}




