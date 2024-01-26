package com.example.demo.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.example.demo.entity.User user = userRepository.findByUsername(username);

		UserBuilder builder = null;
		if (user != null) {
			builder = User.withUsername(username);
			builder.disabled(false);
			builder.password(user.getPassword());
			builder.authorities(new SimpleGrantedAuthority(user.getRole()));
		} else {
			throw new UsernameNotFoundException("User not found");
		}
		return builder.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public com.example.demo.entity.User register(com.example.demo.entity.User user) {
		com.example.demo.entity.User user2=new com.example.demo.entity.User();
		user2.setEmail(user.getEmail());
		user2.setUsername(user.getUsername());
		user2.setPassword(passwordEncoder().encode(user.getPassword()));
		user2.setEnabled(false);
		user2.setRole("ROLE_USER");

		return userRepository.save(user2);
	}
	
	public com.example.demo.entity.User registerCompany(com.example.demo.entity.User company) {
		com.example.demo.entity.User user2=new com.example.demo.entity.User();
		user2.setEmail(company.getEmail());
		user2.setUsername(company.getUsername());
		user2.setPassword(passwordEncoder().encode(company.getPassword()));
		user2.setEnabled(true);
		user2.setRole("ROLE_COMPANY");

		return userRepository.save(user2);
	}

	public com.example.demo.entity.User findUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	public com.example.demo.entity.User transform(UserModel userModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(userModel, com.example.demo.entity.User.class);
	}
	
	public UserModel transform(com.example.demo.entity.User user) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, UserModel.class);
	}
	
	public com.example.demo.entity.User updateUser(UserModel user) {
		// TODO Auto-generated method stub
		return userRepository.save(transform(user));
	}
	
	public List<com.example.demo.entity.User> findUsers() {
		return userRepository.findAll();
	}
	
	public boolean removeUser(int id) {
		userRepository.deleteById(id);
		return false;
	}
	
	public com.example.demo.entity.User updateUser(com.example.demo.entity.User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}
}
