package uz.digitalocean.com.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDto {

    private Long id;

    private String name;

    private String address;

}
