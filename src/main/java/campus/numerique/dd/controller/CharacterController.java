package campus.numerique.dd.controller;

import campus.numerique.dd.dao.CharacterDao;
import campus.numerique.dd.model.Character;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "DD API", description = "The D&D API")
@RestController
public class CharacterController {

    @Autowired
    private CharacterDao characterDao;

    @GetMapping("/")
    public String index() {
        return "Welcome to DUNGEONS & DRAGONS!";
    }

    @GetMapping("/character")
    public List<Character> listCharacter() {
        return characterDao.findAll();
    }

    @GetMapping("/character/{id}")
    public Character getById(@PathVariable int id) {
        return characterDao.findById(id);
    }

    @PostMapping("/character")
    public Character save(@RequestBody Character character) {
        return characterDao.save(character);
    }

    @DeleteMapping("/character/{id}")
    public void delete(@PathVariable int id) {
        characterDao.deleteById(id);
    }

    @PutMapping("/character")
    public void update(@RequestBody Character character) {
        characterDao.save(character);
    }

}
