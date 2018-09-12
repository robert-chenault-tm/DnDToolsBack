package chenaurj.DnDToolsBack.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.Campaign;
import chenaurj.DnDToolsBack.repository.util.CampaignRowMapper;

@Repository("campaignRepository")
public class CampaignRepositoryImpl implements CampaignRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Campaign> getCampaigns(String username) {
		return jdbcTemplate.query("select * from campaign where username = ?", new CampaignRowMapper(), username);
	}

}
