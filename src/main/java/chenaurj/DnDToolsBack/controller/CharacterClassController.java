package chenaurj.DnDToolsBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import chenaurj.DnDToolsBack.model.CharacterClass;
import chenaurj.DnDToolsBack.service.CharacterClassService;

@Controller
public class CharacterClassController {

	@Autowired
	private CharacterClassService characterClassService;
	
	@RequestMapping(value = "/class/{id}", method = RequestMethod.GET)
	public @ResponseBody CharacterClass getCharacterClass(@PathVariable(value = "id") String id) {
		return characterClassService.getCharacterClass(id);
	}
	
	@RequestMapping(value = "/classes/{userName}", method = RequestMethod.GET)
	public @ResponseBody List<CharacterClass> getCharacterClasses(@PathVariable(value = "userName") String userName) {
		return characterClassService.getCharacterClasses(userName);
	}
	
	@RequestMapping(value = "/class", method = RequestMethod.POST)
	public @ResponseBody CharacterClass createCharacterClass(@RequestBody CharacterClass characterClass) {
		return characterClassService.createCharacterClass(characterClass);
	}
}
