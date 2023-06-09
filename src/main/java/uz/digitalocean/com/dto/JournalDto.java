package uz.digitalocean.com.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JournalDto {

    private Long id;
    private String name;
    private Long groupId;

}
