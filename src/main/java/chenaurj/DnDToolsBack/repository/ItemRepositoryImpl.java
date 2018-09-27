package chenaurj.DnDToolsBack.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.DamageDice;
import chenaurj.DnDToolsBack.model.items.ArmorMods;
import chenaurj.DnDToolsBack.model.items.Item;
import chenaurj.DnDToolsBack.model.items.WeaponMods;
import chenaurj.DnDToolsBack.repository.util.ArmorModsRowMapper;
import chenaurj.DnDToolsBack.repository.util.ItemRowMapper;

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
			jdbcTemplate.update("insert into weapon (item_id, weapon_type, simple, one_handed, reach, short_range, long_range) values (?, ?, ?, ?, ?, ?, ?)", item.getId(), item.getWeaponMods().getWeaponType(), item.getWeaponMods().isSimple(), item.getWeaponMods().isOneHanded(), item.getWeaponMods().getReach(), item.getWeaponMods().getShortRange(), item.getWeaponMods().getLongRange());
			for(DamageDice die : item.getWeaponMods().getDamageDice()) {
				jdbcTemplate.update("insert into weapon_damage (weapon_id, dice_number, dice_type, damage_type) values (?, ?, ?, ?)", item.getId(), die.getDiceNumber(), die.getDiceType(), die.getDamageType());
			}
		}
		
		return item;
	}

	@Override
	public Item getItem(String id) {
		Item item;
		WeaponMods weaponMods;
		List<ArmorMods> armorModsList;
		
		try {
			item = jdbcTemplate.queryForObject("select * from item where id = ?", new ItemRowMapper(), id);
			
			armorModsList = jdbcTemplate.query("select * from armor where item_id = ?", new ArmorModsRowMapper(), id);
			if(armorModsList.size() == 0) {
				item.setArmorMods(null);
			} else if(armorModsList.size() == 1) {
				item.setArmorMods(armorModsList.get(0));
			} else {
				//Should not happen currently
			}
			
			List<Map<String, Object>> weaponRows = jdbcTemplate.queryForList("select * from weapon w left join weapon_damage wd on w.item_id = wd.weapon_id where w.item_id = ?", id);
			if(weaponRows.isEmpty()) {
				item.setWeaponMods(null);
			} else {
				weaponMods = new WeaponMods();
				List<DamageDice> dice = new ArrayList<DamageDice>();
				for(Map<String, Object> row : weaponRows) {
					DamageDice die = new DamageDice();
					die.setDiceNumber((int) row.get("dice_number"));
					die.setDiceType((String) row.get("dice_type"));
					die.setDamageType((String) row.get("damage_type"));
					dice.add(die);
				}
				weaponMods.setWeaponType((String) weaponRows.get(0).get("weapon_type"));
				weaponMods.setSimple(((int) weaponRows.get(0).get("simple")) == 1);
				weaponMods.setOneHanded(((int) weaponRows.get(0).get("one_handed")) == 1);
				weaponMods.setReach((int) weaponRows.get(0).get("reach"));
				weaponMods.setShortRange((int) weaponRows.get(0).get("short_range"));
				weaponMods.setLongRange((int) weaponRows.get(0).get("long_range"));
				weaponMods.setDamageDice(dice);
				
				item.setWeaponMods(weaponMods);
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
