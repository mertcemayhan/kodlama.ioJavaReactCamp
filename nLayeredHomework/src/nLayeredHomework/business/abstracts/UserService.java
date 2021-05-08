package nLayeredHomework.business.abstracts;

import java.util.List;

import nLayeredHomework.entities.concretes.User;

public interface UserService {
	
	void add(User user);
	void addWithGoogle(User user);
	void logIn(String email,String password);
	List<User> getAll();

}
