package uz.digitalocean.com.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JournalResponseDto {

    private Long id;
    private String name;
    private Long groupId;

}
