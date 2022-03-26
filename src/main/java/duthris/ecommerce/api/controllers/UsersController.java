package duthris.ecommerce.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import duthris.ecommerce.business.abstracts.UserService;
import duthris.ecommerce.core.utilities.results.DataResult;
import duthris.ecommerce.entities.concretes.User;
import duthris.ecommerce.entities.dtos.UserLoginDto;
import duthris.ecommerce.entities.dtos.UserLoginReturnDto;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
	public User add(@RequestBody User user) {
		return this.userService.add(user);
	}
	
	@PostMapping("/login")
	public DataResult<UserLoginReturnDto> login(@RequestBody UserLoginDto userLoginDto) {
		return this.userService.login(userLoginDto);
	}
}
