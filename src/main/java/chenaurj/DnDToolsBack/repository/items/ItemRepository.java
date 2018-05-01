package chenaurj.DnDToolsBack.repository.items;

import chenaurj.DnDToolsBack.model.items.Item;

public interface ItemRepository {

	Item createItem(Item item);

	Item getItem(String id);

}
