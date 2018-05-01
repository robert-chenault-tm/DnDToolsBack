package chenaurj.DnDToolsBack.repository.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.DamageDice;
import chenaurj.DnDToolsBack.model.items.Item;
import chenaurj.DnDToolsBack.model.items.Weapon;
import chenaurj.DnDToolsBack.repository.DamageDiceRepository;
import chenaurj.DnDToolsBack.repository.items.util.WeaponRowMapper;

@Repository("weaponRepository")
public class WeaponRepositoryImpl implements WeaponRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private DamageDiceRepository damageDiceRepository;
	
	@Override
	public Weapon createWeapon(Weapon weapon) {
		jdbcTemplate.update("insert into weapon (item_id, weapon_type, simple, one_handed, reach, short_range, long_range) values (?, ?, ?, ?, ?, ?, ?)", weapon.getId(), weapon.getWeaponType(), weapon.isSimple(), weapon.isOneHanded(), weapon.getReach(), weapon.getShortRange(), weapon.getLongRange());
		damageDiceRepository.clearDamageDiceFromWeapon(weapon.getId());
		for(DamageDice die : weapon.getDamageDice()) {
			damageDiceRepository.createDamageDiceIfNonExistent(die);
			damageDiceRepository.associateDamageDiceWithWeapon(weapon.getId(), die);
		}
		return getWeapon(weapon.getId());
	}

	@Override
	public Weapon getWeapon(String id) {
		Item item = itemRepository.getItem(id);
		Weapon weapon;
		try {
			weapon = jdbcTemplate.queryForObject("select * from weapon where item_id = ?", new WeaponRowMapper(), id);
			weapon.setDamageDice(damageDiceRepository.getWeaponAssociatedDamageDice(id));
			weapon = new Weapon(item, weapon);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			weapon = null;
		}
		
		return weapon;
	}

}
