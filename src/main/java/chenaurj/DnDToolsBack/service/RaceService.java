package chenaurj.DnDToolsBack.service;

import java.util.List;

import chenaurj.DnDToolsBack.model.Race;

public interface RaceService {

	Race getRace(String id);

	List<Race> getRaces(String userName);

	Race createRace(Race race);

}
