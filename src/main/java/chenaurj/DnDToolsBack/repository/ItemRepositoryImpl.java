package chenaurj.DnDToolsBack.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.DamageDice;
import chenaurj.DnDToolsBack.model.items.ArmorMods;
import chenaurj.DnDToolsBack.model.items.Item;
import chenaurj.DnDToolsBack.model.items.WeaponMods;
import chenaurj.DnDToolsBack.repository.util.ArmorModsRowMapper;
import chenaurj.DnDToolsBack.repository.util.ItemRowMapper;
import chenaurj.DnDToolsBack.repository.util.WeaponModsRowMapper;

@Repository("itemRepository")
public class ItemRepositoryImpl implements ItemRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Item createItem(Item item) {
		jdbcTemplate.update("insert into item (id, username, name, description, rarity, value_in_gp, weight_in_lbs) values (?, ?, ?, ?, ?, ?, ?)", item.getId(), item.getUsername(), item.getName(), item.getDescription(), item.getRarity(), item.getValueInGP(), item.getWeightInlbs());
		if(item.getArmorMods() != null) {
			jdbcTemplate.update("insert into armor (item_id, armor_type, base_ac, strength_req, stealth_disadvantage) values (?, ?, ?, ?, ?)", item.getId(), item.getArmorMods().getArmorType(), item.getArmorMods().getBaseAC(), item.getArmorMods().getStrengthReq(), item.getArmorMods().isStealthDisadvantage());
		} else if(item.getWeaponMods() != null) {
			
		}
		
		return getItem(item.getId());
	}

	@Override
	public Item getItem(String id) {
		Item item;
		WeaponMods weaponMods;
		ArmorMods armorMods;
		List<WeaponMods> singleWeaponMods;
		List<ArmorMods> singleArmorMods;
		try {
			item = jdbcTemplate.queryForObject("select * from item where id = ?", new ItemRowMapper(), id);
			singleWeaponMods = jdbcTemplate.query("select * from weapon w inner join weapon_damage wd on w.item_id = wd.weapon_id inner join damage_dice dd on wd.damage_id = dd.id where w.item_id = ?", new WeaponModsRowMapper(), id);
			singleArmorMods = jdbcTemplate.query("select * from armor where item_id = ?", new ArmorModsRowMapper(), id);
			if(singleWeaponMods.size() == 0) {
				item.setWeaponMods(null);
			} else if(singleWeaponMods.size() == 1) {
				item.setWeaponMods(singleWeaponMods.get(0));
			} else {
				weaponMods = singleWeaponMods.get(0);
				List<DamageDice> dice = weaponMods.getDamageDice();
				for(int i = 1;i < singleWeaponMods.size(); i++) {
					dice.add(singleWeaponMods.get(i).getDamageDice().get(0));
				}
				weaponMods.setDamageDice(dice);
				item.setWeaponMods(weaponMods);
			}
			if(singleArmorMods.size() == 0) {
				item.setArmorMods(null);
			} else if(singleArmorMods.size() == 1) {
				item.setArmorMods(singleArmorMods.get(0));
			} else {
				//
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			item = null;
		}
		
		return item;
	}

	@Override
	public List<Item> getXItemStubs(HashMap<String, String> details) {
		String username = details.get("username");
		String sOfficial = details.get("official");
		String sOwned = details.get("owned");
		String sOthers = details.get("others");
		String search = details.get("search");
		String sNum = details.get("num");
		String sSkip = details.get("skip");
		if(username != null && sOfficial != null && sOwned != null && sOthers != null && search != null && sNum != null && sSkip != null) {
			boolean official = Boolean.valueOf(sOfficial);
			boolean owned = Boolean.valueOf(sOwned);
			boolean others = Boolean.valueOf(sOthers);
			int skip = Integer.parseInt(sSkip);
			int num = Integer.parseInt(sNum);
			search = "%" + search + "%";
			String query = "select * from item where ("
			+ (official ? "username = 'system'" : "false") + " or ("
			+ (owned ? "username = ?" : "(username = ? and false)") + " or "
			+ (others ? "(username <> ? and username <> 'system')" : "(username <> ? and username <> 'system' and false)")
			+ ")) and name like ? limit ?, ?";
			return jdbcTemplate.query(query, new ItemRowMapper(), username, username, search, skip, num);
		} else {
			return null;
		}
	}

	@Override
	public int getResultCount(HashMap<String, String> details) {
		String username = details.get("username");
		String sOfficial = details.get("official");
		String sOwned = details.get("owned");
		String sOthers = details.get("others");
		String search = details.get("search");
		if(username != null && sOfficial != null && sOwned != null && sOthers != null && search != null) {
			boolean official = Boolean.valueOf(sOfficial);
			boolean owned = Boolean.valueOf(sOwned);
			boolean others = Boolean.valueOf(sOthers);
			search = "%" + search + "%";
			String query = "select count(id) from item where ("
			+ (official ? "username = 'system'" : "false") + " or ("
			+ (owned ? "username = ?" : "(username = ? and false)") + " or "
			+ (others ? "(username <> ? and username <> 'system')" : "(username <> ? and username <> 'system' and false)")
			+ ")) and name like ?";
			return jdbcTemplate.queryForObject(query, Integer.class, username, username, search);
		} else {
			return 0;
		}
	}

}
