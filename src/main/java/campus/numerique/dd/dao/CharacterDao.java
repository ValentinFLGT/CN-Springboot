package campus.numerique.dd.dao;

import campus.numerique.dd.model.Character;

import java.util.List;

public interface CharacterDao {

    public List<Character> findAll();

    public Character findById(int id);

    public Character add(Character character);

    public Character putById(Character newCharacter, int id);

    public Character deleteById(int id);
}
