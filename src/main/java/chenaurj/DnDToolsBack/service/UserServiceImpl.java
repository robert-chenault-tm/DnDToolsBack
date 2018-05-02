package chenaurj.DnDToolsBack.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import chenaurj.DnDToolsBack.model.User;
import chenaurj.DnDToolsBack.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		user.setEnabled(true);
		user.setId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepository.createUser(user);
	}

	@Override
	public boolean authenticateUser(String username, String password) {
		User user = userRepository.getUser(username);
		if(user != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(passwordEncoder.matches(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
