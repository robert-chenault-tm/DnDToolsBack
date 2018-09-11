package chenaurj.DnDToolsBack.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import chenaurj.DnDToolsBack.model.Race;

public class RaceRowMapper implements RowMapper<Race> {

	@Override
	public Race mapRow(ResultSet rs, int rowNum) throws SQLException {
		Race race = new Race();
		race.setId(rs.getString("id"));
		race.setName(rs.getString("name"));
		
		return race;
	}

}
