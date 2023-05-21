package uz.digitalocean.com.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GROUP", indexes = {@Index(name = "uniqueIndex", columnList = "ID", unique = true)})
public class Group {

    @Id
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "GR_YEAR")
    private Integer year;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Integer isActive; // 1 active | 0 not active

    @Column(name = "FACULTY_ID")
    private Long facultyId;

    @Column(name = "CREATED_AT",updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

//    @ManyToOne
//    @JoinColumn(name = "STUDENT_ID")
//    private Student student;

//    @ManyToOne
//    @JoinColumn(name = "FACULTY_ID")
//    private Faculty faculty;
}
