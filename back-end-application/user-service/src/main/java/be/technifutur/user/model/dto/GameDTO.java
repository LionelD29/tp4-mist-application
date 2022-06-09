package be.technifutur.user.model.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class GameDTO {

    private UUID ref;

}
