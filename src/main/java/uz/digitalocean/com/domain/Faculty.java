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
@Table(name = "FACULTY", indexes = {@Index(name = "uniqueIndex", columnList = "ID", unique = true)})
public class Faculty extends BaseEntity<String> {

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Integer isActive; // 1 active | 0 not active

    @Column(name = "UNIVERSITY_ID", nullable = false)
    private Long universityId; // I prefer using like this. JPA has a lot of configurations. But this one is easy for native queries.

//    @OneToMany(mappedBy = "GROUP")
//    private List<Group> groups;
//
//    @ManyToOne
//    @JoinColumn(name = "UNIVERSITY_ID")
//    private University university;
}
