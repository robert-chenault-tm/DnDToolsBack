package chenaurj.DnDToolsBack.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chenaurj.DnDToolsBack.model.Race;
import chenaurj.DnDToolsBack.repository.RaceRepository;

@Service("raceService")
public class RaceServiceImpl implements RaceService {

	@Autowired
	private RaceRepository raceRepository;
	
	@Override
	public Race getRace(String id) {
		return raceRepository.getRace(id);
	}

	@Override
	public List<Race> getRaces(String username) {
		return raceRepository.getRaces(username);
	}

	@Override
	public Race createRace(Race race) {
		race.setId(UUID.randomUUID().toString());
		
		return raceRepository.createRace(race);
	}

}
