package chenaurj.DnDToolsBack.repository;

import java.util.List;

import chenaurj.DnDToolsBack.model.Campaign;

public interface CampaignRepository {

	List<Campaign> getCampaigns(String username);

	Campaign createCampaign(Campaign campaign);

	Campaign getFullCampaign(String id);

}
