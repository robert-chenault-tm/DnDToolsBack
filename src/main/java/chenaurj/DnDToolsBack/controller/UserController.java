package chenaurj.DnDToolsBack.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import chenaurj.DnDToolsBack.model.User;
import chenaurj.DnDToolsBack.service.UserService;
import chenaurj.DnDToolsBack.util.ServiceError;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/generate", method = RequestMethod.POST)
	public @ResponseBody User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody boolean authenticateUser(@RequestBody HashMap<String, String> data) {
		return userService.authenticateUser(data.get("username"), data.get("password"));//username, password);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ServiceError> handleEmpty(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<ServiceError> handleDuplicate(RuntimeException ex) {
		ServiceError error = new ServiceError(HttpStatus.BAD_REQUEST.value(), "This username already exists");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
