package chenaurj.DnDToolsBack.repository;

import java.util.List;

import chenaurj.DnDToolsBack.model.DamageDice;

public interface DamageDiceRepository {

	void createDamageDiceIfNonExistent(DamageDice die);

	void associateDamageDiceWithWeapon(String id, DamageDice die);

	List<DamageDice> getWeaponAssociatedDamageDice(String id);

	void clearDamageDiceFromWeapon(String id);

}
