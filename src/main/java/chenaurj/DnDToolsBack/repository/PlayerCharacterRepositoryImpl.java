package chenaurj.DnDToolsBack.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.PlayerCharacter;
import chenaurj.DnDToolsBack.repository.util.PlayerCharacterRowMapper;

@Repository
public class PlayerCharacterRepositoryImpl implements PlayerCharacterRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public PlayerCharacter getCharacter(String id) {
		PlayerCharacter character;
		try {
			character = jdbcTemplate.queryForObject("select * from character where id = ?", new PlayerCharacterRowMapper(), id);
		} catch(Exception ex) {
			System.out.println("Exception caught in UserRepositoryImpl.getUser: " + ex.getMessage());
			character = null;
		}
		return character;
	}

	@Override
	public List<PlayerCharacter> getCharacters(String userName) {
		return jdbcTemplate.query("select * from character where username = ?", new PlayerCharacterRowMapper(), userName);
	}

	@Override
	public PlayerCharacter createCharacter(PlayerCharacter character) {
		jdbcTemplate.update("insert into character (id, username, name, experience, level, strength, dexterity, intelligence, constitution, wisdom, charisma, race_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", character.getId(), character.getUserName(), character.getName(), character.getExperience(), character.getLevel(), character.getStrength(), character.getDexterity(), character.getIntelligence(), character.getConstitution(), character.getWisdom(), character.getCharisma(), character.getRaceId());
		return character;
		
	}
	
}
