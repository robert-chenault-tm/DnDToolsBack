package chenaurj.DnDToolsBack.model.items;

public class ArmorMods {

	public enum ArmorTypes{LIGHT, MEDIUM, HEAVY, SHIELD};
	
	private String itemId;
	private ArmorTypes armorType;
	private int baseAC;
	private int strengthReq;
	private boolean stealthDisadvantage;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public ArmorTypes getArmorType() {
		return armorType;
	}
	public void setArmorType(ArmorTypes armorType) {
		this.armorType = armorType;
	}
	public int getBaseAC() {
		return baseAC;
	}
	public void setBaseAC(int baseAC) {
		this.baseAC = baseAC;
	}
	public int getStrengthReq() {
		return strengthReq;
	}
	public void setStrengthReq(int strengthReq) {
		this.strengthReq = strengthReq;
	}
	public boolean isStealthDisadvantage() {
		return stealthDisadvantage;
	}
	public void setStealthDisadvantage(boolean stealthDisadvantage) {
		this.stealthDisadvantage = stealthDisadvantage;
	}
}
