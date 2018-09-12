package chenaurj.DnDToolsBack.service;

import java.util.List;

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

}
