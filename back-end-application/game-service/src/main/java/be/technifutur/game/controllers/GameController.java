package be.technifutur.game.controllers;

import be.technifutur.game.exceptions.ElementNotFoundException;
import be.technifutur.game.metier.service.game.GameService;
import be.technifutur.game.models.dto.GameDTO;
import be.technifutur.game.models.forms.GameForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<GameDTO> getGames(){
        return service.getGames();
    }

    @GetMapping(params = "reference")
    public ResponseEntity<GameDTO> getGameByReference(@RequestParam(name = "reference") UUID reference){
        try {
            GameDTO dto = service.getGameByReference(reference);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "GameController")
                    .body(service.getGameByReference(reference));
        } catch (ElementNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(params = "title")
    public ResponseEntity<GameDTO> getGameByTitle(@RequestParam(name = "title") String title){
        try {
            GameDTO dto = service.getGameByTitle(title);
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from controller", "GameController")
                    .body(service.getGameByTitle(title));
        } catch (ElementNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<GameDTO> insertGame(@RequestBody GameForm form){
        return ResponseEntity.ok(service.insertGame(form));
    }

    @PutMapping("/{reference}/update")
    public ResponseEntity<GameDTO> updateGame(@RequestBody GameForm form, @PathVariable UUID reference){
        return ResponseEntity.ok(service.updateGame(reference, form));
    }

    @DeleteMapping("/{reference}/delete")
    public ResponseEntity<GameDTO> delete(@PathVariable UUID reference){
        return ResponseEntity.ok(service.deleteGame(reference));
    }

}
