package chenaurj.DnDToolsBack.model;

import java.util.List;

public class Campaign {

	private String id;
	private String name;
	private String username;
	private List<PlayerCharacter> characters;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<PlayerCharacter> getCharacters() {
		return characters;
	}
	public void setCharacters(List<PlayerCharacter> characters) {
		this.characters = characters;
	}
	
}
