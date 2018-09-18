package chenaurj.DnDToolsBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import chenaurj.DnDToolsBack.model.Campaign;
import chenaurj.DnDToolsBack.service.CampaignService;

@Controller
public class CampaignController {

	@Autowired
	private CampaignService campaignService;
	
	@RequestMapping(value = "/campaigns/{username}", method = RequestMethod.GET)
	public @ResponseBody List<Campaign> getCampaigns(@PathVariable(value = "username") String username) {
		return campaignService.getCampaigns(username);
	}
	
	@RequestMapping(value = "/fullCampaign/{id}", method = RequestMethod.GET)
	public @ResponseBody Campaign getFullCampaign(@PathVariable(value = "id") String id) {
		return campaignService.getFullCampaign(id);
	}
	
	@RequestMapping(value = "/campaign", method = RequestMethod.POST)
	public @ResponseBody Campaign createCampaign(@RequestBody Campaign campaign) {
		return campaignService.createCampaign(campaign);
	}
}
