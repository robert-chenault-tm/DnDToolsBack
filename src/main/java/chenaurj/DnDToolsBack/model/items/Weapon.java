package chenaurj.DnDToolsBack.model.items;

import java.util.List;

import chenaurj.DnDToolsBack.model.DamageDice;

public class Weapon extends Item {

	private String weaponType;
	private boolean simple;
	private boolean oneHanded;
	private int reach;
	private int shortRange;
	private int longRange;
	private List<DamageDice> damageDice;
	
	public Weapon() {
		
	}
	
	public Weapon(Item item, Weapon weapon) {
		this.setId(item.getId());
		this.setName(item.getName());
		this.setDescription(item.getDescription());
		this.setRarity(item.getRarity());
		this.setValueInGP(item.getValueInGP());
		this.setWeightInlbs(item.getWeightInlbs());
		this.setWeaponType(weapon.getWeaponType());
		this.setSimple(weapon.isSimple());
		this.setOneHanded(weapon.isOneHanded());
		this.setReach(weapon.getReach());
		this.setShortRange(weapon.getShortRange());
		this.setLongRange(weapon.getLongRange());
		this.setDamageDice(weapon.getDamageDice());
	}
	
	public String getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}
	public boolean isSimple() {
		return simple;
	}
	public void setSimple(boolean simple) {
		this.simple = simple;
	}
	public boolean isOneHanded() {
		return oneHanded;
	}
	public void setOneHanded(boolean oneHanded) {
		this.oneHanded = oneHanded;
	}
	public int getReach() {
		return reach;
	}
	public void setReach(int reach) {
		this.reach = reach;
	}
	public int getShortRange() {
		return shortRange;
	}
	public void setShortRange(int shortRange) {
		this.shortRange = shortRange;
	}
	public int getLongRange() {
		return longRange;
	}
	public void setLongRange(int longRange) {
		this.longRange = longRange;
	}
	public List<DamageDice> getDamageDice() {
		return damageDice;
	}
	public void setDamageDice(List<DamageDice> damageDice) {
		this.damageDice = damageDice;
	}
	
}
