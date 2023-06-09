package uz.digitalocean.com.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    private Long id;
    private Long facultyId;
    private String name;
    private Integer year;
}
