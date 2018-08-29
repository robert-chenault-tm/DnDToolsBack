package chenaurj.DnDToolsBack.service;

import java.util.List;

import chenaurj.DnDToolsBack.model.PlayerCharacter;

public interface PlayerCharacterService {

	PlayerCharacter getCharacter(String id);
	
	List<PlayerCharacter> getCharacters(String userName);
	
	PlayerCharacter createCharacter(PlayerCharacter character);
	
}
