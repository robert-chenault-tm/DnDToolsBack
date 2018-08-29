package chenaurj.DnDToolsBack.repository;

import java.util.List;

import chenaurj.DnDToolsBack.model.PlayerCharacter;

public interface PlayerCharacterRepository {

	PlayerCharacter getCharacter(String id);
	
	List<PlayerCharacter> getCharacters(String userName);
	
	PlayerCharacter createCharacter(PlayerCharacter character);
	
}
