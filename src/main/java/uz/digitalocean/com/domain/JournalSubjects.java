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
@Table(name = "JOURNAL_SUBJECTS", indexes = {@Index(name = "uniqueIndex", columnList = "ID", unique = true)})
public class JournalSubjects extends BaseEntity<String> {

    @Column(name = "JOURNAL_ID")
    private Long journalId;

    @Column(name = "SUBJECT_ID")
    private Long subjectId;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Integer isActive; // 1 active | 0 not active
}
