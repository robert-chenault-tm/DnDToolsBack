package chenaurj.DnDToolsBack.service;

import java.util.List;

import chenaurj.DnDToolsBack.model.CharacterClass;

public interface CharacterClassService {

	CharacterClass getCharacterClass(String id);

	List<CharacterClass> getCharacterClasses(String username);

	CharacterClass createCharacterClass(CharacterClass characterClass);

}
