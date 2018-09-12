package chenaurj.DnDToolsBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import chenaurj.DnDToolsBack.model.Race;
import chenaurj.DnDToolsBack.service.RaceService;

@Controller
public class RaceController {

	@Autowired
	private RaceService raceService;
	
	@RequestMapping(value = "/race/{id}", method = RequestMethod.GET)
	public @ResponseBody Race getRace(@PathVariable(value = "id") String id) {
		return raceService.getRace(id);
	}
	
	@RequestMapping(value = "/races/{username}", method = RequestMethod.GET)
	public @ResponseBody List<Race> getRaces(@PathVariable(value = "username") String username) {
		return raceService.getRaces(username);
	}
	
	@RequestMapping(value = "/race", method = RequestMethod.POST)
	public @ResponseBody Race createRace(@RequestBody Race race) {
		return raceService.createRace(race);
	}
}
