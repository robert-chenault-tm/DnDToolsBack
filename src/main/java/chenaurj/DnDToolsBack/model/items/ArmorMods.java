package chenaurj.DnDToolsBack.model.items;

public class ArmorMods {
	
	private String itemId;
	private String armorType;
	private int baseAC;
	private int strengthReq;
	private boolean stealthDisadvantage;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	public String getArmorType() {
		return armorType;
	}
	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}
}
