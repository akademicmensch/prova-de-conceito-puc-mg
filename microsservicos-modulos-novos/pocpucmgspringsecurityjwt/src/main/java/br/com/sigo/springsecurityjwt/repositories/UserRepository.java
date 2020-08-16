package br.com.sigo.springsecurityjwt.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.sigo.springsecurityjwt.models.SampleUser;

@Repository
public class UserRepository {
	
	List<SampleUser> users = new ArrayList<>();
	
	public List<SampleUser> getAllUsers(){
		return users;
	}
	
	public void addUser(SampleUser user) {
		users.add(user);
	}

}
