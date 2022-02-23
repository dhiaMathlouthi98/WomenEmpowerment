package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.User;


public interface IUserService {

	
	List<User> retrieveAllUser();
	
	User addUser(User c);

	void deleteUser(int id);

	//User updateUser(User c);

	User retrieveUser(int id);

	User updateUser(User c);

	
}
