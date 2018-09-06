package chenaurj.DnDToolsBack.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import chenaurj.DnDToolsBack.model.PlayerCharacter;

public class PlayerCharacterRowMapper implements RowMapper<PlayerCharacter> {

	@Override
	public PlayerCharacter mapRow(ResultSet rs, int rowNum) throws SQLException {
		PlayerCharacter character = new PlayerCharacter();
		character.setId(rs.getString("id"));
		character.setUserName(rs.getString("username"));
		character.setName(rs.getString("name"));
		character.setExperience(rs.getInt("experience"));
		character.setLevel(rs.getInt("level"));
		character.setStrength(rs.getInt("strength"));
		character.setDexterity(rs.getInt("dexterity"));
		character.setIntelligence(rs.getInt("intelligence"));
		character.setConstitution(rs.getInt("constitution"));
		character.setWisdom(rs.getInt("wisdom"));
		character.setCharisma(rs.getInt("charisma"));
		character.setRaceId(rs.getString("race_id"));
		character.setRaceName(rs.getString("race_name"));
		return character;
	}

}
