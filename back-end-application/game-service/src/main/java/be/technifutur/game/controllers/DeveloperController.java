package be.technifutur.game.controllers;

import be.technifutur.game.exceptions.ElementNotFoundException;
import be.technifutur.game.metier.service.developer.DeveloperService;
import be.technifutur.game.models.dto.DeveloperDTO;
import be.technifutur.game.models.dto.EditorDTO;
import be.technifutur.game.models.forms.DeveloperForm;
import be.technifutur.game.models.forms.EditorForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/developer")
public class DeveloperController {

    private final DeveloperService service;

    public DeveloperController(DeveloperService service) {
        this.service = service;
    }

    // --- GET ---
    @GetMapping
    public List<DeveloperDTO> getDevelopers(){
        return service.getDevelopers();
    }

    @GetMapping(params = "reference")
    public ResponseEntity<DeveloperDTO> getDeveloperByReference(@RequestParam(name = "reference") UUID reference){
        try {
            DeveloperDTO dto = service.getDeveloperByReference(reference);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "GameController")
                    .body(service.getDeveloperByReference(reference));
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(params = "name")
    public ResponseEntity<DeveloperDTO> getDeveloperByName(@RequestParam(name = "name") String name){
        try {
            DeveloperDTO dto = service.getDeveloperByName(name);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "GameController")
                    .body(service.getDeveloperByName(name));
        } catch (ElementNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // --- INSERT ---
    @PostMapping("/add")
    public ResponseEntity<DeveloperDTO> insertDeveloper(@RequestBody DeveloperForm form){
        return ResponseEntity.ok(service.insertDeveloper(form));
    }


    // --- UPDATE ---
    @PutMapping("/update")
    public ResponseEntity<DeveloperDTO> updateDeveloper(@RequestBody DeveloperForm form, @RequestParam(name = "reference") UUID reference){
        return ResponseEntity.ok(service.updateDeveloper(reference, form));
    }


    // --- DELETE ---
    @DeleteMapping("/delete")
    public ResponseEntity<DeveloperDTO> deleteDeveloper(@RequestParam(name = "reference") UUID reference){
        return ResponseEntity.ok(service.deleteDeveloper(reference));
    }
}
