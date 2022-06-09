package be.technifutur.auth.model.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class UserAccountDTO {

    private UUID ref;
    private String username;
    private String email;
    private List<String> roles;

}
