package chenaurj.DnDToolsBack.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import chenaurj.DnDToolsBack.model.DamageDice;
import chenaurj.DnDToolsBack.model.items.WeaponMods;

public class WeaponModsRowMapper implements RowMapper<WeaponMods> {
	
	@Override
	public WeaponMods mapRow(ResultSet rs, int rowNum) throws SQLException {
		WeaponMods mods = new WeaponMods();
		DamageDice die = new DamageDice();
		List<DamageDice> dice = new ArrayList<DamageDice>();
		
		mods.setWeaponType(rs.getString("weapon_type"));
		mods.setSimple(rs.getBoolean("simple"));
		mods.setOneHanded(rs.getBoolean("one_handed"));
		mods.setReach(rs.getInt("reach"));
		mods.setShortRange(rs.getInt("short_range"));
		mods.setLongRange(rs.getInt("long_range"));
		die.setDiceNumber(rs.getInt("dice_number"));
		die.setDiceType(rs.getString("dice_type"));
		die.setDamageType(rs.getString("damage_type"));
		dice.add(die);
		mods.setDamageDice(dice);
		
		
		return mods;
	}
}
