package campus.numerique.dd.controller;

import campus.numerique.dd.dao.CharacterDao;
import campus.numerique.dd.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    private CharacterDao characterDao;


    @GetMapping("/")
    public String index() {
        return "Welcome to DUNGEONS & DRAGONS!";
    }

    @GetMapping("/character")
    public List<Character> get() {
        return characterDao.findAll();
    }

    @GetMapping("/character/{id}")
    public Character getById(@PathVariable int id) {
        return characterDao.findById(id);
    }

    @PostMapping("/character")
    public Character add(@RequestBody Character character) {
        return characterDao.add(character);
    }

    @DeleteMapping("/character/{id}")
    public Character delete(@PathVariable int id) {
        return characterDao.deleteById(id);
    }

    @PutMapping("/character/{id}")
    public Character put(@RequestBody Character newCharacter, @PathVariable int id) {
        return characterDao.putById(newCharacter, id);
    }

}
