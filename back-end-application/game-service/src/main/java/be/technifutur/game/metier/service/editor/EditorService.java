package be.technifutur.game.metier.service.editor;

import be.technifutur.game.models.dto.EditorDTO;
import be.technifutur.game.models.forms.EditorForm;

import java.util.List;
import java.util.UUID;

public interface EditorService {

    List<EditorDTO> getDevelopers();

    EditorDTO getEditorByUUID(UUID reference);

    EditorDTO getEditorByName(String name);

    EditorDTO insertEditor(EditorForm editorForm);

    EditorDTO updateEditor(EditorForm editorForm);

    EditorDTO deleteEditor(UUID reference);
}
