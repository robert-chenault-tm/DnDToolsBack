package chenaurj.DnDToolsBack.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.Campaign;
import chenaurj.DnDToolsBack.model.PlayerCharacter;
import chenaurj.DnDToolsBack.repository.util.CampaignRowMapper;

@Repository("campaignRepository")
public class CampaignRepositoryImpl implements CampaignRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Campaign> getCampaigns(String username) {
		return jdbcTemplate.query("select * from campaign where username = ?", new CampaignRowMapper(), username);
	}

	@Override
	public Campaign createCampaign(Campaign campaign) {
		jdbcTemplate.update("insert into campaign (id, name, username) values (?, ?, ?)", campaign.getId(), campaign.getName(), campaign.getUsername());
		return campaign;
	}

	@Override
	public Campaign getFullCampaign(String id) {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select campaign.id as campaign_id, campaign.name as campaign_name, campaign.username as campaign_username, race.name as race_name, class.name as class_name, `character`.* from campaign left join campaign_character on campaign_character.campaign_id = campaign.id left join `character` on campaign_character.character_id = `character`.id left join class on `character`.class_id = class.id left join race on `character`.race_id = race.id where campaign.id = ?", id);
		if(rows.isEmpty()) {
			//Temp
			return new Campaign();
		}
		
		Campaign campaign = new Campaign();
		List<PlayerCharacter> characters = new ArrayList<PlayerCharacter>();
		if(rows.get(0).get("id") != null) {
			for(Map<String, Object> row : rows) {
				PlayerCharacter character = new PlayerCharacter();
				character.setId((String) row.get("id"));
				character.setUsername((String) row.get("username"));
				character.setName((String) row.get("name"));
				character.setExperience((int) row.get("experience"));
				character.setLevel((int) row.get("level"));
				character.setStrength((int) row.get("strength"));
				character.setDexterity((int) row.get("dexterity"));
				character.setIntelligence((int) row.get("intelligence"));
				character.setConstitution((int) row.get("constitution"));
				character.setWisdom((int) row.get("wisdom"));
				character.setCharisma((int) row.get("charisma"));
				character.setRaceId((String) row.get("race_id"));
				character.setRaceName((String) row.get("race_name"));
				character.setClassId((String) row.get("class_id"));
				character.setClassName((String) row.get("class_name"));
				characters.add(character);
			}
		}

		campaign.setId((String) rows.get(0).get("campaign_id"));
		campaign.setName((String) rows.get(0).get("campaign_name"));
		campaign.setUsername((String) rows.get(0).get("campaign_username"));
		campaign.setCharacters(characters);
		
		return campaign;
	}

	@Override
	public Campaign editCampaign(Campaign campaign) {

		jdbcTemplate.update("delete from campaign_character where campaign_id = ?", campaign.getId());
		for(PlayerCharacter character : campaign.getCharacters()) {
			jdbcTemplate.update("insert into campaign_character (campaign_id, character_id) values (?, ?)", campaign.getId(), character.getId());
		}
		return campaign;
	}

}
