package br.com.estudo.validations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.validations.dto.UserRequest;
import br.com.estudo.validations.entity.User;
import br.com.estudo.validations.exception.UserNotFoundException;
import br.com.estudo.validations.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
		return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.ok(userService.getUser(id)); 
	}
	
}
