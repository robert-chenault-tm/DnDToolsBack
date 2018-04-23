package chenaurj.DnDToolsBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import chenaurj.DnDToolsBack.model.EncounterDifficultyData;
import chenaurj.DnDToolsBack.service.StaticDataService;

@Controller
public class StaticDataController {

	@Autowired StaticDataService staticDataService;
	
	@RequestMapping(value = "/encounterData", method = RequestMethod.GET)
	public @ResponseBody EncounterDifficultyData getEncounterDifficultyData() {
		return staticDataService.getEncounterDifficultyData();
	}
	
}