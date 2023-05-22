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
public class StudentFullInfoDto {

    @Id
    @Transient
    private Long id;

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "facultyName")
    private String facultyName;

    @Column(name = "groupName")
    private String groupName;

}
