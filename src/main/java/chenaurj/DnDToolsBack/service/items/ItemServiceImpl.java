package chenaurj.DnDToolsBack.service.items;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chenaurj.DnDToolsBack.model.items.Item;
import chenaurj.DnDToolsBack.repository.items.ItemRepository;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Item createItem(Item item) {
		item.setId(UUID.randomUUID().toString());
		return itemRepository.createItem(item);
	}

	@Override
	public Item getItem(String id) {
		return itemRepository.getItem(id);
	}

}
