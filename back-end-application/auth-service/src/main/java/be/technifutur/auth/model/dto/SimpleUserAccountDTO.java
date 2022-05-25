package be.technifutur.auth.model.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class SimpleUserAccountDTO {

    private UUID ref;
    private List<String> roles;

}
