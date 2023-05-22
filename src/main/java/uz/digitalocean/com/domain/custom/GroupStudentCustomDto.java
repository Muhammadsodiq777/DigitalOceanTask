package uz.digitalocean.com.domain.custom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroupStudentCustomDto {

    @Id
    @Transient
    private Long id;

    @Column(name = "groupName")
    private String groupName;

    @Column(name = "studentNumber")
    private String studentNumber;

}
