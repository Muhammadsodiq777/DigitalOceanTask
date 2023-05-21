package uz.digitalocean.com.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacultyResponseDto {

    private Long id;
    private Long universityId;
    private String name;

}
