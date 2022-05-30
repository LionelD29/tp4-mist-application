package be.technifutur.shared.model.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class UserDTO {

    private UUID ref;
    private List<String> roles;

}
