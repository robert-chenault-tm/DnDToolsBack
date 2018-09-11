package chenaurj.DnDToolsBack.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.Race;
import chenaurj.DnDToolsBack.repository.util.RaceRowMapper;

@Repository("raceRepository")
public class RaceRepositoryImpl implements RaceRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Race getRace(String id) {
		Race race;
		try {
			race = jdbcTemplate.queryForObject("select * from race where id = ?", new RaceRowMapper(), id);
		} catch(Exception ex) {
			System.out.println("Exception caught in RaceRepositoryImpl.getRace: " + ex.getMessage());
			race = null;
		}
		
		return race;
	}

	@Override
	public List<Race> getRaces(String userName) {
		//userName will eventually be used when custom races are implemented, for now it can be ignored
		return jdbcTemplate.query("select * from race", new RaceRowMapper());
	}

	@Override
	public Race createRace(Race race) {
		jdbcTemplate.update("insert into race (id, name) values (?, ?)", race.getId(), race.getName());
		return race;
	}

}
