package br.com.exlivraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.exlivraria.repository.UserRepository;

@Service 
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository repository;

	
	//Constructor
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = repository.findByUsername(username);
				if(user != null) {
					return user;
				}
				else {
					throw new UsernameNotFoundException("Username " + username + " not found");
				}
	}

	


	
	
}
