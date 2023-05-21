package uz.digitalocean.com.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.digitalocean.com.domain.base.BaseEntity;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UNIVERSITY", indexes = {@Index(name = "uniqueIndex", columnList = "ID", unique = true)})
public class University extends BaseEntity<String> {

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "IS_ACTIVE")
    private Integer isActive = 1; // 1 active | 0 not active

//    @OneToMany(mappedBy = "FACULTY")
//    private List<Faculty> faculties;
}
