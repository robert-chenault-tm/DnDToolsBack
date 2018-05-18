package chenaurj.DnDToolsBack.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import chenaurj.DnDToolsBack.model.items.Item;
import chenaurj.DnDToolsBack.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public @ResponseBody Item createItem(@RequestBody Item item) {
		return itemService.createItem(item);
	}
	
	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public @ResponseBody Item getItem(@PathVariable(value = "id") String id) {
		return itemService.getItem(id);
	}
	
	@RequestMapping(value = "/items", method = RequestMethod.POST)
	public @ResponseBody List<Item> getXItemStubs(@RequestBody HashMap<String, String> details) {
		return itemService.getXItemStubs(details);
	}
	
	@RequestMapping(value = "/items/count", method = RequestMethod.POST)
	public @ResponseBody int getResultCount(@RequestBody HashMap<String, String> details) {
		return itemService.getResultCount(details);
	}
	
}
