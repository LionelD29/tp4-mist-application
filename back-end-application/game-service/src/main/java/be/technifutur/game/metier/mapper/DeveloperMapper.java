package be.technifutur.game.metier.mapper;

import be.technifutur.game.models.dto.DeveloperDTO;
import be.technifutur.game.models.entities.Developer;
import be.technifutur.game.models.forms.DeveloperForm;
import org.springframework.stereotype.Service;

@Service
public class DeveloperMapper {

    public DeveloperDTO entityToDTO(Developer entity) {
        if (entity == null) {
            return null;
        }

        return DeveloperDTO.builder()
                .id(entity.getId())
                .reference(entity.getReference())
                .name(entity.getName())
                .games(entity.getGames() == null ? null : entity.getGames().stream().map(DeveloperDTO.GameDTO::of).toList())
                .build();
    }

    public Developer formToEntity(DeveloperForm form) {
        if (form == null) {
            return null;
        }

        return Developer.builder()
                .name(form.getName())
                .build();
    }
}
