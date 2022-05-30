package be.technifutur.game.controllers;

import be.technifutur.game.exceptions.ElementNotFoundException;
import be.technifutur.game.metier.service.developer.DeveloperService;
import be.technifutur.game.models.dto.DeveloperDTO;
import be.technifutur.game.models.dto.EditorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
