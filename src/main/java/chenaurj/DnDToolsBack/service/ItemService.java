package chenaurj.DnDToolsBack.service;

import java.util.HashMap;
import java.util.List;

import chenaurj.DnDToolsBack.model.items.Item;

public interface ItemService {

	Item createItem(Item item);

	Item getItem(String id);

	List<Item> getXItemStubs(HashMap<String, String> details);

	int getResultCount(HashMap<String, String> details);

}
