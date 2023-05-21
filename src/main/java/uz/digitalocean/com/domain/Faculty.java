package uz.digitalocean.com.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FACULTY", indexes = {@Index(name = "uniqueIndex", columnList = "ID", unique = true)})
public class Faculty {

    @Id
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Integer isActive; // 1 active | 0 not active

    @Column(name = "UNIVERSITY_ID", nullable = false)
    private Long universityId; // I prefer using like this. JPA has a lot of configurations. But this one is easy for native queries.

    @Column(name = "CREATED_AT",updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

//    @OneToMany(mappedBy = "GROUP")
//    private List<Group> groups;
//
//    @ManyToOne
//    @JoinColumn(name = "UNIVERSITY_ID")
//    private University university;
}
