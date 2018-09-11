package chenaurj.DnDToolsBack.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chenaurj.DnDToolsBack.model.PlayerCharacter;
import chenaurj.DnDToolsBack.repository.PlayerCharacterRepository;

@Service("playerCharacterService")
public class PlayerCharacterServiceImpl implements PlayerCharacterService {

	@Autowired
	private PlayerCharacterRepository characterRepository;
	
	@Override
	public PlayerCharacter getCharacter(String id) {
		return characterRepository.getCharacter(id);
	}

	@Override
	public List<PlayerCharacter> getCharacters(String userName) {
		return characterRepository.getCharacters(userName);
	}

	@Override
	public PlayerCharacter createCharacter(PlayerCharacter character) {
		character.setId(UUID.randomUUID().toString());
		return characterRepository.createCharacter(character);
	}

}
