package chenaurj.DnDToolsBack.repository;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.EncounterDifficultyData;
import chenaurj.DnDToolsBack.repository.util.ExpMultiplierRowMapper;
import chenaurj.DnDToolsBack.repository.util.SingleCRExpValueRowMapper;
import chenaurj.DnDToolsBack.repository.util.SingleExpThresholdRowMapper;


@Repository("staticDataRepository")
public class StaticDataRepositoryImpl implements StaticDataRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EncounterDifficultyData getEncounterDifficultyData() {
		EncounterDifficultyData data = new EncounterDifficultyData();
		HashMap<String, Integer> crExpValues = new HashMap<String, Integer>();
		HashMap<Integer, Integer> easyThresholds = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> mediumThresholds = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> hardThresholds = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> deadlyThresholds = new HashMap<Integer, Integer>();
		List<Float> expMultipliers;
		List<SimpleEntry<String, Integer>> crExpEntries;
		List<SimpleEntry<String, SimpleEntry<Integer, Integer>>> thresholds;
		crExpEntries = jdbcTemplate.query("select * from cr_exp_value", new SingleCRExpValueRowMapper());
		for(SimpleEntry<String, Integer> entry : crExpEntries) {
			crExpValues.put(entry.getKey(), entry.getValue());
		}
		thresholds = jdbcTemplate.query("select * from exp_threshold", new SingleExpThresholdRowMapper());
		for(SimpleEntry<String, SimpleEntry<Integer, Integer>> entry : thresholds) {
			if(entry.getKey().equals("easy")) {
				easyThresholds.put(entry.getValue().getKey(), entry.getValue().getValue());
			} else if(entry.getKey().equals("medium") ) {
				mediumThresholds.put(entry.getValue().getKey(), entry.getValue().getValue());
			} else if(entry.getKey().equals("hard") ) {
				hardThresholds.put(entry.getValue().getKey(), entry.getValue().getValue());
			} else if(entry.getKey().equals("deadly") ) {
				deadlyThresholds.put(entry.getValue().getKey(), entry.getValue().getValue());
			} else {
				System.out.println("Unexpected threshold level: " + entry.getKey());
			}
		}
		
		expMultipliers = jdbcTemplate.query("select * from exp_multiplier", new ExpMultiplierRowMapper());
		
		data.setCrExpValues(crExpValues);
		data.setEasyThresholds(easyThresholds);
		data.setMediumThresholds(mediumThresholds);
		data.setHardThresholds(hardThresholds);
		data.setDeadlyThresholds(deadlyThresholds);
		data.setExpMultipliers(expMultipliers);
		
		return data;
	}

}