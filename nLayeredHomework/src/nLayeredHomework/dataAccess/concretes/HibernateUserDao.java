package nLayeredHomework.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import nLayeredHomework.dataAccess.abstracts.UserDao;
import nLayeredHomework.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	
	ArrayList<User> users;
	public HibernateUserDao() {
		users = new ArrayList<User>();
		users.add(new User(1, "Mert Cem", "Ayhan", "mert@cem.com", "11111"));
	}
	
	

	@Override
	public void add(User user) {
		System.out.println("Kullanýcý sisteme eklendi "+user.getFirstName());
		
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}

	@Override
	public boolean get(String email, String password) {
		boolean result=true;
		for(User user:users) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				result=true;
				break;
			}else {
				result=false;
			}
		}
		return result; 
	}

}
