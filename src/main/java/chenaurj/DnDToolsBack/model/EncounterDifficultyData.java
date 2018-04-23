package chenaurj.DnDToolsBack.model;

import java.util.HashMap;
import java.util.List;

public class EncounterDifficultyData {

	private HashMap<String, Integer> crExpValues;
	private HashMap<Integer, Integer> easyThresholds;
	private HashMap<Integer, Integer> mediumThresholds;
	private HashMap<Integer, Integer> hardThresholds;
	private HashMap<Integer, Integer> deadlyThresholds;
	private List<Float> expMultipliers;
	
	public HashMap<String, Integer> getCrExpValues() {
		return crExpValues;
	}
	public void setCrExpValues(HashMap<String, Integer> crExpValues) {
		this.crExpValues = crExpValues;
	}
	public HashMap<Integer, Integer> getEasyThresholds() {
		return easyThresholds;
	}
	public void setEasyThresholds(HashMap<Integer, Integer> easyThresholds) {
		this.easyThresholds = easyThresholds;
	}
	public HashMap<Integer, Integer> getMediumThresholds() {
		return mediumThresholds;
	}
	public void setMediumThresholds(HashMap<Integer, Integer> mediumThresholds) {
		this.mediumThresholds = mediumThresholds;
	}
	public HashMap<Integer, Integer> getHardThresholds() {
		return hardThresholds;
	}
	public void setHardThresholds(HashMap<Integer, Integer> hardThresholds) {
		this.hardThresholds = hardThresholds;
	}
	public HashMap<Integer, Integer> getDeadlyThresholds() {
		return deadlyThresholds;
	}
	public void setDeadlyThresholds(HashMap<Integer, Integer> deadlyThresholds) {
		this.deadlyThresholds = deadlyThresholds;
	}
	public List<Float> getExpMultipliers() {
		return expMultipliers;
	}
	public void setExpMultipliers(List<Float> expMultipliers) {
		this.expMultipliers = expMultipliers;
	}
}
