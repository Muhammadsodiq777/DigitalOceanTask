package uz.digitalocean.com.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityResponseDto {

    private Long id;

    private String name;

    private String address;

}
