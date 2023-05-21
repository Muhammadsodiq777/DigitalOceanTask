package uz.digitalocean.com.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {

    private Long id;

    private Long universityId;

    private String name;

}
