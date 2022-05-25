package be.technifutur.game.metier.service.developer;

import be.technifutur.game.models.dto.DeveloperDTO;
import be.technifutur.game.models.entities.Developer;
import be.technifutur.game.models.forms.DeveloperForm;

import java.util.List;
import java.util.UUID;

public interface DeveloperService {

    List<DeveloperDTO> getDevelopers();

    DeveloperDTO getDeveloperByUUID(UUID reference);

    DeveloperDTO getDeveloperByName(String name);

    DeveloperDTO insertDeveloper(DeveloperForm developerForm);

    DeveloperDTO updateDeveloper(DeveloperForm developerForm);

    DeveloperDTO deleteDeveloper(UUID reference);
}
