package chenaurj.DnDToolsBack.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import chenaurj.DnDToolsBack.model.Campaign;

public class CampaignRowMapper implements RowMapper<Campaign> {

	@Override
	public Campaign mapRow(ResultSet rs, int rowNum) throws SQLException {
		Campaign campaign = new Campaign();
		campaign.setId(rs.getString("id"));
		campaign.setName(rs.getString("name"));
		campaign.setUsername(rs.getString("username"));
		
		return campaign;
	}

}
