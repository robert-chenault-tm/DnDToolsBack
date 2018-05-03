package chenaurj.DnDToolsBack.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import chenaurj.DnDToolsBack.model.User;
import chenaurj.DnDToolsBack.repository.util.UserRowMapper;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User createUser(User user) {
		jdbcTemplate.update("insert into users (id, username, password, enabled) values (?, ?, ?, ?)", user.getId(), user.getUsername(), user.getPassword(), user.isEnabled());
		jdbcTemplate.update("insert into authorities (user_id, username, authority) values (?, ?, ?)", user.getId(), user.getUsername(), "ROLE_USER");
		return getUser(user.getUsername());
	}

	@Override
	public User getUser(String username) {
		User user;
		try {
			user = jdbcTemplate.queryForObject("select * from users where username = ?", new UserRowMapper(), username);
		} catch(Exception ex) {
			System.out.println("Exception caught in UserRepositoryImpl.getUser: " + ex.getMessage());
			user = null;
		}
		
		return user;
	}

	
	
}
