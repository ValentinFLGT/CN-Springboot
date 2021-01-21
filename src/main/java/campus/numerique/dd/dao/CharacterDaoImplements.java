package campus.numerique.dd.dao;

import campus.numerique.dd.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CharacterDaoImplements implements CharacterDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Character> findAll() {
        return jdbcTemplate.query(
                "select * from Characters",
                (rs, rowNum) ->
                        new Character(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("type")
                        )
        );
    }

    // jdbcTemplate.queryForObject, populates a single object
    @Override
    public Optional<Character> findById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from Characters where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Character(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("type")
                        ))
        );
    }

    @Override
    public int add(Character character) {
        return jdbcTemplate.update(
                "insert into Characters (name, type) values(?,?)",
                character.getName(), character.getType());
    }

    @Override
    public int update(Character character, int id) {
        return jdbcTemplate.update(
                "update Characters set name = ?, type = ? where id = ?",
                character.getName(), character.getType(), id);
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
                "delete from Characters where id = ?",
                id);
    }

}
