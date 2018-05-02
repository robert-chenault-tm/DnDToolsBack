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
		jdbcTemplate.update("insert into authorities (userid, username, authority) values (?, ?, ?)", user.getId(), user.getUsername(), "ROLE_USER");
		return getUser(user.getId());
	}

	@Override
	public User getUser(String id) {
		User user;
		try {
			user = jdbcTemplate.queryForObject("select * from users where id = ?", new UserRowMapper(), id);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			user = null;
		}
		
		return user;
	}

	
	
}
