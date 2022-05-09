package az.thesis.happyhrthesisprojectwebapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MessageDto {
    private String message;
}
