package chenaurj.DnDToolsBack.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap.SimpleEntry;

import org.springframework.jdbc.core.RowMapper;

public class SingleCRExpValueRowMapper implements RowMapper<SimpleEntry<String, Integer>> {

	@Override
	public SimpleEntry<String, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
		SimpleEntry<String, Integer> entry = new SimpleEntry<String, Integer>(rs.getString("cr"), rs.getInt("exp"));
		return entry;
	}

}
