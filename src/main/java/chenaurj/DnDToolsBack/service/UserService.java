package chenaurj.DnDToolsBack.service;

import chenaurj.DnDToolsBack.model.User;

public interface UserService {

	User createUser(User user);

	boolean authenticateUser(String username, String password);

}
