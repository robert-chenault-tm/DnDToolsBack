package chenaurj.DnDToolsBack.repository.items;

import chenaurj.DnDToolsBack.model.items.Weapon;

public interface WeaponRepository {

	Weapon createWeapon(Weapon weapon);

	Weapon getWeapon(String id);

}
