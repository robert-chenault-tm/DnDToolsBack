package chenaurj.DnDToolsBack.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.DamageDice;
import chenaurj.DnDToolsBack.repository.util.DamageDiceRowMapper;

@Repository("damageDiceRepository")
public class DamageDiceRepositoryImpl implements DamageDiceRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createDamageDiceIfNonExistent(DamageDice die) {
		try {
			int count = jdbcTemplate.queryForObject("select count(id) from damage_dice where dice_number = ? and dice_type = ? and damage_type = ?", Integer.class, die.getDiceNumber(), die.getDamageType(), die.getDamageType());
			if(count == 0) {
				String id = UUID.randomUUID().toString();
				jdbcTemplate.update("insert into damage_dice (id, dice_number, dice_type, damage_type) values (?, ?, ?, ?)", id, die.getDiceNumber(), die.getDiceType(), die.getDamageType());
			}
		} catch(Exception ex) {
			System.out.println("Exception caught in DamageDiceRepositoryImpl.createDamageDiceIfNonExistent: " + ex.getMessage());
		}
		
	}

	@Override
	public void associateDamageDiceWithWeapon(String id, DamageDice die) {
		try {
			String damageId = jdbcTemplate.queryForObject("select id from damage_dice where dice_number = ? and dice_type = ? and damage_type = ?", String.class, die.getDiceNumber(), die.getDamageType(), die.getDamageType());
			jdbcTemplate.update("insert into weapon_damage (weapon_id, damage_id) values (?, ?)", id, damageId);
		} catch(Exception ex) {
			System.out.println("Exception caught in DamageDiceRepositoryImpl.associateDamageDiceWithWeapon: " + ex.getMessage());
		}
	}

	@Override
	public List<DamageDice> getWeaponAssociatedDamageDice(String id) {
		return jdbcTemplate.query("select d.dice_number, d.dice_type, d.damage_type from damage_dice d inner join weapon_damage w on w.damage_id = d.id where w.weapon_id = ?", new DamageDiceRowMapper(), id);
	}

	@Override
	public void clearDamageDiceFromWeapon(String id) {
		jdbcTemplate.update("delete from weapon_damage where weapon_id = ?", id);
	}

}
