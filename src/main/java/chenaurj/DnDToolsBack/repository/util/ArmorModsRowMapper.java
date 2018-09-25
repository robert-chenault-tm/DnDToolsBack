package chenaurj.DnDToolsBack.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import chenaurj.DnDToolsBack.model.items.ArmorMods;

public class ArmorModsRowMapper implements RowMapper<ArmorMods> {

	@Override
	public ArmorMods mapRow(ResultSet rs, int rowNum) throws SQLException {
		ArmorMods armor = new ArmorMods();
		
		armor.setItemId(rs.getString("item_id"));
		armor.setArmorType(rs.getString("armor_type"));
		armor.setBaseAC(rs.getInt("base_ac"));
		armor.setStrengthReq(rs.getInt("strength_req"));
		armor.setStealthDisadvantage(rs.getBoolean("stealth_disadvantage"));
		
		return armor;
	}

}
