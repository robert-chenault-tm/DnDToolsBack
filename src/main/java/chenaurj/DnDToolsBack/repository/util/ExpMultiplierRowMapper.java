package chenaurj.DnDToolsBack.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ExpMultiplierRowMapper implements RowMapper<Float> {

	@Override
	public Float mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getFloat("exp_multiplier");
	}

}
