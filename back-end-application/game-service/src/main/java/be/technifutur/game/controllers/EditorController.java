package be.technifutur.game.controllers;

import be.technifutur.game.exceptions.ElementNotFoundException;
import be.technifutur.game.metier.service.editor.EditorService;
import be.technifutur.game.models.dto.EditorDTO;
import be.technifutur.game.models.forms.EditorForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/editor")
public class EditorController {

    private final EditorService service;

    public EditorController(EditorService service) {
        this.service = service;
    }

    // --- GET ---
    @GetMapping
    public List<EditorDTO> getEditors(){
        return service.getEditors();
    }

    @GetMapping(params = "reference")
    public ResponseEntity<EditorDTO> getEditorByReference(@RequestParam(name = "reference") UUID reference){
        try {
            EditorDTO dto = service.getEditorByReference(reference);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "GameController")
                    .body(service.getEditorByReference(reference));
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(params = "name")
    public ResponseEntity<EditorDTO> getEditorByName(@RequestParam(name = "name") String name){
        try {
            EditorDTO dto = service.getEditorByName(name);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "GameController")
                    .body(service.getEditorByName(name));
        } catch (ElementNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // --- INSERT ---
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<EditorDTO> insertEditor(@RequestBody EditorForm form){
        return ResponseEntity.ok(service.insertEditor(form));
    }


    // --- UPDATE ---
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<EditorDTO> update(@RequestBody EditorForm form, @RequestParam(name = "reference") UUID reference){
        return ResponseEntity.ok(service.updateEditor(reference, form));
    }


    // --- DELETE ---
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<EditorDTO> deleteEditor(@RequestParam(name = "reference") UUID reference){
        return ResponseEntity.ok(service.deleteEditor(reference));
    }
}
