package chenaurj.DnDToolsBack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chenaurj.DnDToolsBack.model.EncounterDifficultyData;
import chenaurj.DnDToolsBack.repository.StaticDataRepository;

@Service("staticDataService")
public class StaticDataServiceImpl implements StaticDataService {

	@Autowired StaticDataRepository staticDataRepository;
	
	@Override
	public EncounterDifficultyData getEncounterDifficultyData() {
		return staticDataRepository.getEncounterDifficultyData();
	}
	
}
