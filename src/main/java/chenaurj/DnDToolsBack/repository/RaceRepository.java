package chenaurj.DnDToolsBack.repository;

import java.util.List;

import chenaurj.DnDToolsBack.model.Race;

public interface RaceRepository {

	Race getRace(String id);

	List<Race> getRaces(String userName);

	Race createRace(Race race);
}
