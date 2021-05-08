package nLayeredHomework.dataAccess.abstracts;

import java.util.List;

import nLayeredHomework.entities.concretes.User;

public interface UserDao {
	void add(User user);
	boolean get(String email,String password);
	List<User> getAll();
}
