package chenaurj.DnDToolsBack.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap.SimpleEntry;

import org.springframework.jdbc.core.RowMapper;

public class SingleExpThresholdRowMapper implements RowMapper<SimpleEntry<String, SimpleEntry<Integer, Integer>>> {

	@Override
	public SimpleEntry<String, SimpleEntry<Integer, Integer>> mapRow(ResultSet rs, int rowNum) throws SQLException {
		SimpleEntry<Integer, Integer> innerEntry = new SimpleEntry<Integer, Integer>(rs.getInt("level"), rs.getInt("exp"));
		SimpleEntry<String, SimpleEntry<Integer, Integer>> entry = new SimpleEntry<String, SimpleEntry<Integer, Integer>>(rs.getString("difficulty"), innerEntry);
		return entry;
	}

}