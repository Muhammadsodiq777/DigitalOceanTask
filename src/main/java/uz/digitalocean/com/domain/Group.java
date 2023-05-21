package uz.digitalocean.com.domain;

import jakarta.persistence.*;
import lombok.*;
import uz.digitalocean.com.domain.base.BaseEntity;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GROUP", indexes = {@Index(name = "uniqueIndex", columnList = "ID", unique = true)})
public class Group extends BaseEntity<String> {

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Integer isActive; // 1 active | 0 not active

    @Column(name = "FACULTY_ID")
    private Long facultyId;

//    @ManyToOne
//    @JoinColumn(name = "STUDENT_ID")
//    private Student student;

//    @ManyToOne
//    @JoinColumn(name = "FACULTY_ID")
//    private Faculty faculty;
}
