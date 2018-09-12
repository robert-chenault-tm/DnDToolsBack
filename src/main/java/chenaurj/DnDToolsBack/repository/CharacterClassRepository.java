package chenaurj.DnDToolsBack.repository;

import java.util.List;

import chenaurj.DnDToolsBack.model.CharacterClass;

public interface CharacterClassRepository {

	CharacterClass getCharacterClass(String id);

	List<CharacterClass> getCharacterClasses(String username);

	CharacterClass createCharacterClass(CharacterClass characterClass);
}
