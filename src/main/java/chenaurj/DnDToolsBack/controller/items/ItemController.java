package chenaurj.DnDToolsBack.controller.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import chenaurj.DnDToolsBack.model.items.Item;
import chenaurj.DnDToolsBack.service.items.ItemService;

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
	
}
