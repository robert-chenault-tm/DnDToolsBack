package chenaurj.DnDToolsBack.service;

import java.util.List;

import chenaurj.DnDToolsBack.model.Campaign;

public interface CampaignService {

	List<Campaign> getCampaigns(String username);

	Campaign createCampaign(Campaign campaign);

}
