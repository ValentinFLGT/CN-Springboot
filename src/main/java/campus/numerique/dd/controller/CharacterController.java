package campus.numerique.dd.controller;

import campus.numerique.dd.dao.CharacterDao;
import campus.numerique.dd.model.Character;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "DD API", description = "the D&D API")
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
    public Optional<Character> getById(@PathVariable int id) {
        return characterDao.findById(id);
    }

    @PostMapping("/character")
    public int add(@RequestBody Character character) {
        return characterDao.add(character);
    }

    @DeleteMapping("/character/{id}")
    public int delete(@PathVariable int id) {
        return characterDao.deleteById(id);
    }

    @PutMapping("/character/{id}")
    public int update(@RequestBody Character character, @PathVariable int id) {
        return characterDao.update(character, id);
    }

}
