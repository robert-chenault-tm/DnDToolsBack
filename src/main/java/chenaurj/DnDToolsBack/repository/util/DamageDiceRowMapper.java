package chenaurj.DnDToolsBack.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import chenaurj.DnDToolsBack.model.DamageDice;

public class DamageDiceRowMapper implements RowMapper<DamageDice> {

	@Override
	public DamageDice mapRow(ResultSet rs, int rowNum) throws SQLException {
		DamageDice die = new DamageDice();
		
		die.setDiceNumber(rs.getInt("dice_number"));
		die.setDiceType(rs.getString("dice_type"));
		die.setDamageType(rs.getString("damage_type"));
		
		return die;
	}

}
