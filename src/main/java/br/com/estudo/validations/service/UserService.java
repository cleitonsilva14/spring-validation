package br.com.estudo.validations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estudo.validations.dto.UserRequest;
import br.com.estudo.validations.entity.User;
import br.com.estudo.validations.exception.UserNotFoundException;
import br.com.estudo.validations.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(UserRequest userRequest) {
		User user = User.build(0L, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUser(int id) throws UserNotFoundException {
		User user = userRepository.findByUserId(id);
		if(user != null) {
			return user;
		}else {
			throw new UserNotFoundException("user not found with id " + id);
		}
	}
	
}
