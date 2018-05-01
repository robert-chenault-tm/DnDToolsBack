package chenaurj.DnDToolsBack.service.items;

import chenaurj.DnDToolsBack.model.items.Item;

public interface ItemService {

	Item createItem(Item item);

	Item getItem(String id);

}
