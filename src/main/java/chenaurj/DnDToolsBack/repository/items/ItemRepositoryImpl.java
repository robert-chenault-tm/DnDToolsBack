package chenaurj.DnDToolsBack.repository.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.items.Item;
import chenaurj.DnDToolsBack.repository.items.util.ItemRowMapper;

@Repository("itemRepository")
public class ItemRepositoryImpl implements ItemRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Item createItem(Item item) {
		jdbcTemplate.update("insert into item (id, name, description, rarity, value_in_gp, weight_in_lbs) values (?, ?, ?, ?, ?, ?)", item.getId(), item.getName(), item.getDescription(), item.getRarity(), item.getValueInGP(), item.getWeightInlbs());

		
		return getItem(item.getId());
	}

	@Override
	public Item getItem(String id) {
		Item item;
		
		try {
			item = jdbcTemplate.queryForObject("select * from item where id = ?", new ItemRowMapper(), id);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			item = null;
		}
		
		return item;
	}

}
