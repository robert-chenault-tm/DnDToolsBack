package chenaurj.DnDToolsBack.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chenaurj.DnDToolsBack.model.Campaign;
import chenaurj.DnDToolsBack.repository.CampaignRepository;

@Service("campaignService")
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;
	
	@Override
	public List<Campaign> getCampaigns(String username) {
		return campaignRepository.getCampaigns(username);
	}

	@Override
	public Campaign createCampaign(Campaign campaign) {
		campaign.setId(UUID.randomUUID().toString());
		return campaignRepository.createCampaign(campaign);
	}

	@Override
	public Campaign getFullCampaign(String id) {
		return campaignRepository.getFullCampaign(id);
	}

	@Override
	public Campaign editCampaign(Campaign campaign) {
		return campaignRepository.editCampaign(campaign);
	}

}
