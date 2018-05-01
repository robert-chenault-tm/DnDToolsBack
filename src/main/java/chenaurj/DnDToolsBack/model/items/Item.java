package chenaurj.DnDToolsBack.model.items;

public class Item {

	private String id;
	private String name;
	private String description;
	private String rarity;
	private float valueInGP;
	private float weightInlbs;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public float getValueInGP() {
		return valueInGP;
	}
	public void setValueInGP(float valueInGP) {
		this.valueInGP = valueInGP;
	}
	public float getWeightInlbs() {
		return weightInlbs;
	}
	public void setWeightInlbs(float weightInlbs) {
		this.weightInlbs = weightInlbs;
	}
	
}
