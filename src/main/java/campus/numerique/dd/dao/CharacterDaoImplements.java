package campus.numerique.dd.dao;

import campus.numerique.dd.model.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterDaoImplements implements CharacterDao {

    // ArrayList to simulate our database
    public static List<Character> characters = new ArrayList<>();

    static {
        characters.add(new Character(1, "Valentin", "Warrior"));
        characters.add(new Character(2, "Damien", "Warrior"));
        characters.add(new Character(3, "Aurelie", "Wizard"));
        characters.add(new Character(4, "Adil", "Warrior"));
        characters.add(new Character(5, "Sonia", "Wizard"));
    }

    @Override
    public List<Character> findAll() {
        return characters;
    }

    @Override
    public Character findById(int id) {
        for (Character character : characters) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

    @Override
    public Character add(Character character) {
        characters.add(character);
        return character;
    }

}
