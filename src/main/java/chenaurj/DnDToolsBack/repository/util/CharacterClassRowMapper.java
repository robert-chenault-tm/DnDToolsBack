package chenaurj.DnDToolsBack.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import chenaurj.DnDToolsBack.model.CharacterClass;

public class CharacterClassRowMapper implements RowMapper<CharacterClass> {

	@Override
	public CharacterClass mapRow(ResultSet rs, int rowNum) throws SQLException {
		CharacterClass characterClass = new CharacterClass();
		characterClass.setId(rs.getString("id"));
		characterClass.setName(rs.getString("name"));
		
		return characterClass;
	}

}
