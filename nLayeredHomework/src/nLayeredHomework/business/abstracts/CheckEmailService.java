package nLayeredHomework.business.abstracts;

import nLayeredHomework.entities.concretes.User;

public interface CheckEmailService {
	
	boolean checkEmail(User user,UserService service);

}
