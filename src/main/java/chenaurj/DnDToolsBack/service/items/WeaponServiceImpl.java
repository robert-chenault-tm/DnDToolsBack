package chenaurj.DnDToolsBack.service.items;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chenaurj.DnDToolsBack.model.items.Weapon;
import chenaurj.DnDToolsBack.repository.items.ItemRepository;
import chenaurj.DnDToolsBack.repository.items.WeaponRepository;

@Service("weaponService")
public class WeaponServiceImpl implements WeaponService {

	@Autowired
	private WeaponRepository weaponRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Weapon createWeapon(Weapon weapon) {
		weapon.setId(UUID.randomUUID().toString());
		itemRepository.createItem(weapon);
		return weaponRepository.createWeapon(weapon);
	}

	@Override
	public Weapon getWeapon(String id) {
		return weaponRepository.getWeapon(id);
	}

}
