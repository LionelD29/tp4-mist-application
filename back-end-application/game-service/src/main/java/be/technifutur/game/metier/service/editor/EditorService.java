package be.technifutur.game.metier.service.editor;

import be.technifutur.game.models.dto.EditorDTO;
import be.technifutur.game.models.forms.EditorForm;

import java.util.List;
import java.util.UUID;

public interface EditorService {

    List<EditorDTO> getEditors();

    EditorDTO getEditorByReference(UUID reference);

    EditorDTO getEditorByName(String name);

    EditorDTO insertEditor(EditorForm editorForm);

    EditorDTO updateEditor(UUID reference, EditorForm editorForm);

    EditorDTO deleteEditor(UUID reference);
}
