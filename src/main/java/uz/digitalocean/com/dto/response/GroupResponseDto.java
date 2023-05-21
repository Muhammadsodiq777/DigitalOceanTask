package uz.digitalocean.com.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupResponseDto {

    private Long id;
    private Long facultyId;
    private String name;
    private Integer year;
}
