package chenaurj.DnDToolsBack.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import chenaurj.DnDToolsBack.model.items.Item;

public class ItemRowMapper implements RowMapper<Item> {

	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item = new Item();
		
		item.setId(rs.getString("id"));
		item.setName(rs.getString("name"));
		item.setDescription(rs.getString("description"));
		item.setRarity(rs.getString("rarity"));
		item.setValueInGP(rs.getFloat("value_in_gp"));
		item.setWeightInlbs(rs.getFloat("weight_in_lbs"));
		
		return item;
	}

}
