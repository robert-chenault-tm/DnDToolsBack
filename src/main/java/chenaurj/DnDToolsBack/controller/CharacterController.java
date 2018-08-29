package chenaurj.DnDToolsBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import chenaurj.DnDToolsBack.model.PlayerCharacter;
import chenaurj.DnDToolsBack.service.PlayerCharacterService;

@Controller
public class CharacterController {

	@Autowired
	private PlayerCharacterService characterService;
	
	@RequestMapping(value = "/character/{id}", method = RequestMethod.GET)
	public @ResponseBody PlayerCharacter getCharacter(@PathVariable(value = "id") String id) {
		return characterService.getCharacter(id);
	}
	
	@RequestMapping(value = "/characters/{userName}", method = RequestMethod.GET)
	public @ResponseBody List<PlayerCharacter> getCharacters(@PathVariable(value = "userName") String userName) {
		return characterService.getCharacters(userName);
	}
	
	@RequestMapping(value = "/character", method = RequestMethod.POST)
	public @ResponseBody PlayerCharacter createCharacter(@RequestBody PlayerCharacter character) {
		return characterService.createCharacter(character);
	}
}
