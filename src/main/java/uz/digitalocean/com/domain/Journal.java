package uz.digitalocean.com.domain;


import jakarta.persistence.*;
import lombok.*;
import uz.digitalocean.com.domain.base.BaseEntity;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "JOURNAL", indexes = {@Index(name = "uniqueIndex", columnList = "ID", unique = true)})
public class Journal extends BaseEntity<String> {

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "GROUP_ID", nullable = false)
    private Long groupId;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Integer isActive; // 1 active | 0 not active

//    @OneToOne
//    private Group group;
}
