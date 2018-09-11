package chenaurj.DnDToolsBack.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.PlayerCharacter;
import chenaurj.DnDToolsBack.repository.util.PlayerCharacterRowMapper;

@Repository("playerCharacterRepository")
public class PlayerCharacterRepositoryImpl implements PlayerCharacterRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public PlayerCharacter getCharacter(String id) {
		PlayerCharacter character;
		try {
			character = jdbcTemplate.queryForObject("select `character`.*, race.name as race_name, class.name as class_name from `character` join race on `character`.race_id = race.id join class on `character`.class_id = class.id where `character`.id = ?", new PlayerCharacterRowMapper(), id);
		} catch(Exception ex) {
			System.out.println("Exception caught in PlayerCharacterRepositoryImpl.getCharacter: " + ex.getMessage());
			character = null;
		}
		return character;
	}

	@Override
	public List<PlayerCharacter> getCharacters(String userName) {
		return jdbcTemplate.query("select `character`.*, race.name as race_name, class.name as class_name from `character` join race on `character`.race_id = race.id join class on `character`.class_id = class.id where `character`.username = ?", new PlayerCharacterRowMapper(), userName);
	}

	@Override
	public PlayerCharacter createCharacter(PlayerCharacter character) {
		jdbcTemplate.update("insert into `character` (id, username, name, experience, level, strength, dexterity, intelligence, constitution, wisdom, charisma, race_id, class_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", character.getId(), character.getUsername(), character.getName(), character.getExperience(), character.getLevel(), character.getStrength(), character.getDexterity(), character.getIntelligence(), character.getConstitution(), character.getWisdom(), character.getCharisma(), character.getRaceId(), character.getClassId());
		return character;
		
	}
	
}
