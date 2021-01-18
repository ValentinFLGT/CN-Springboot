package campus.numerique.dd.controller;

import campus.numerique.dd.dao.CharacterDao;
import campus.numerique.dd.model.Character;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    private final CharacterDao characterDao;

    // Initiate a characterDao to access its methods
    public CharacterController(CharacterDao characterDao) {
        this.characterDao = characterDao;
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to DUNGEONS & DRAGONS!";
    }

    @GetMapping("/character")
    public List<Character> getCharacter() {
        return characterDao.findAll();
    }

    @GetMapping("/character/{id}")
    public Character getCharacterById(@PathVariable int id) {
        return characterDao.findById(id);
    }

}
