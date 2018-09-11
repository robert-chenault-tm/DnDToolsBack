package chenaurj.DnDToolsBack.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chenaurj.DnDToolsBack.model.CharacterClass;
import chenaurj.DnDToolsBack.repository.CharacterClassRepository;

@Service("characterClassService")
public class CharacterClassServiceImpl implements CharacterClassService {

	@Autowired
	private CharacterClassRepository characterClassRepository;
	
	@Override
	public CharacterClass getCharacterClass(String id) {
		return characterClassRepository.getCharacterClass(id);
	}

	@Override
	public List<CharacterClass> getCharacterClasses(String userName) {
		return characterClassRepository.getCharacterClasses(userName);
	}

	@Override
	public CharacterClass createCharacterClass(CharacterClass characterClass) {
		characterClass.setId(UUID.randomUUID().toString());
		
		return characterClassRepository.createCharacterClass(characterClass);
	}

}
