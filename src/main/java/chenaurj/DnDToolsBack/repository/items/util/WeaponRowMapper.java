package chenaurj.DnDToolsBack.repository.items.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import chenaurj.DnDToolsBack.model.items.Weapon;

public class WeaponRowMapper implements RowMapper<Weapon> {

	@Override
	public Weapon mapRow(ResultSet rs, int rowNum) throws SQLException {
		Weapon weapon = new Weapon();
		
		weapon.setId(rs.getString("item_id"));
		weapon.setWeaponType(rs.getString("weapon_type"));
		weapon.setSimple(rs.getBoolean("simple"));
		weapon.setOneHanded(rs.getBoolean("one_handed"));
		weapon.setReach(rs.getInt("reach"));
		weapon.setShortRange(rs.getInt("short_range"));
		weapon.setLongRange(rs.getInt("long_range"));

		return weapon;
	}

}
