package chenaurj.DnDToolsBack.repository;

import chenaurj.DnDToolsBack.model.User;

public interface UserRepository {

	User createUser(User user);

	User getUser(String username);

}
