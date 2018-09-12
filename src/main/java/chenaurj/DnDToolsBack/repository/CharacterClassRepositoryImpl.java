package chenaurj.DnDToolsBack.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.CharacterClass;
import chenaurj.DnDToolsBack.repository.util.CharacterClassRowMapper;

@Repository("characterClassRepository")
public class CharacterClassRepositoryImpl implements CharacterClassRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public CharacterClass getCharacterClass(String id) {
		CharacterClass characterClass;
		
		try {
			characterClass = jdbcTemplate.queryForObject("select * from class where id = ?", new CharacterClassRowMapper(), id);
		} catch(Exception ex) {
			System.out.println("Exception caught in CharacterClassRepositoryImpl.getCharacterClass: " + ex.getMessage());
			characterClass = null;
		}
		
		return characterClass;
	}

	@Override
	public List<CharacterClass> getCharacterClasses(String username) {
		//username will eventually be used when custom classes are implemented, for now it can be ignored
		return jdbcTemplate.query("select * from class", new CharacterClassRowMapper());
	}

	@Override
	public CharacterClass createCharacterClass(CharacterClass characterClass) {
		jdbcTemplate.update("insert into class (id, name) values (?, ?)", characterClass.getId(), characterClass.getName());
		return characterClass;
	}

}
