package be.technifutur.game.metier.service.editor;

import be.technifutur.game.models.dto.EditorDTO;
import be.technifutur.game.models.forms.EditorForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EditorServiceImpl implements EditorService {
    @Override
    public List<EditorDTO> getDevelopers() {
        return null;
    }

    @Override
    public EditorDTO getEditorByUUID(UUID reference) {
        return null;
    }

    @Override
    public EditorDTO getEditorByName(String name) {
        return null;
    }

    @Override
    public EditorDTO insertEditor(EditorForm editorForm) {
        return null;
    }

    @Override
    public EditorDTO updateEditor(EditorForm editorForm) {
        return null;
    }

    @Override
    public EditorDTO deleteEditor(UUID reference) {
        return null;
    }
}
