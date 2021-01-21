package campus.numerique.dd.dao;

import campus.numerique.dd.model.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterDao {

    List<Character> findAll();

    Optional<Character> findById(int id);

    int add(Character character);

    int update(Character character, int id);

    int deleteById(int id);
}
