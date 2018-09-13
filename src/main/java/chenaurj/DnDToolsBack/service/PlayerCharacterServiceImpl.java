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
	private PlayerCharacterRepository playerCharacterRepository;
	
	@Override
	public PlayerCharacter getCharacter(String id) {
		return playerCharacterRepository.getCharacter(id);
	}

	@Override
	public List<PlayerCharacter> getCharacters(String userName) {
		return playerCharacterRepository.getCharacters(userName);
	}

	@Override
	public PlayerCharacter createCharacter(PlayerCharacter character) {
		character.setId(UUID.randomUUID().toString());
		return playerCharacterRepository.createCharacter(character);
	}

}
