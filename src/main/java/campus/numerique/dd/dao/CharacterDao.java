package campus.numerique.dd.dao;

import campus.numerique.dd.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterDao extends JpaRepository<Character, Integer> {

    Character findById(int id);

}
