package be.technifutur.game.controllers;

import be.technifutur.game.exceptions.ElementNotFoundException;
import be.technifutur.game.metier.service.game.GameService;
import be.technifutur.game.models.dto.DetailedGameDTO;
import be.technifutur.game.models.dto.GameDTO;
import be.technifutur.game.models.forms.GameInsertForm;
import be.technifutur.game.models.forms.GameUpdateForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    // --- GET ---
    @GetMapping
    public List<DetailedGameDTO> getGames(){
        return service.getGames();
    }

    @GetMapping(params = "reference")
    public ResponseEntity<DetailedGameDTO> getGameByReference(@RequestParam(name = "reference") UUID reference){
        try {
            DetailedGameDTO dto = service.getGameByReference(reference);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "GameController")
                    .body(service.getGameByReference(reference));
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(params = "title")
    public ResponseEntity<DetailedGameDTO> getGameByTitle(@RequestParam(name = "title") String title){
        try {
            DetailedGameDTO dto = service.getGameByTitle(title);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "GameController")
                    .body(service.getGameByTitle(title));
        } catch (ElementNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // --- POST ---
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<GameDTO> insertGame(@RequestBody GameInsertForm form){
        return ResponseEntity.ok(service.insertGame(form));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/add-list")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertGameList(@RequestBody List<GameInsertForm> list){
        service.insertGameList(list);
    }


    // --- PUT ---
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<GameDTO> updateGame(@RequestBody GameUpdateForm form, @RequestParam(name = "reference") UUID reference){
        return ResponseEntity.ok(service.updateGame(reference, form));
    }


    // --- DELETE ---
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<DetailedGameDTO> deleteGame(@RequestParam(name = "reference") UUID reference){
        return ResponseEntity.ok(service.deleteGame(reference));
    }


    // --- UPDATE DEV/EDIT ---
    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping(value = "/updateDeveloper")
    public ResponseEntity<GameDTO> updateDeveloperOfGame(@RequestParam(name = "reference") UUID reference, @RequestParam(name = "devReference") UUID devReference){
        return ResponseEntity.ok(service.updateDeveloperOfGame(reference, devReference));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping(value = "/updateEditor")
    public ResponseEntity<GameDTO> updateEditorOfGame(@RequestParam(name = "reference") UUID reference, @RequestParam(name = "editReference") UUID editReference){
        return ResponseEntity.ok(service.updateEditorOfGame(reference, editReference));
    }

}
