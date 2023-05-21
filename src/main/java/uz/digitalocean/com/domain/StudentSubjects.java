package uz.digitalocean.com.domain;

import jakarta.persistence.*;
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
public class Student extends BaseEntity<String> {

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Integer isActive; // 1 active | 0 not active

    @Column(name = "GROUP_ID", nullable = false)
    private Long groupId;
    
  //  @OneToMany(mappedBy = "GROUP")
//    private List<Group> group;
}




