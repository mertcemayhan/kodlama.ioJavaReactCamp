package nLayeredHomework.business.concretes;

import java.util.List;

import nLayeredHomework.business.abstracts.CheckEmailService;
import nLayeredHomework.business.abstracts.UserService;
import nLayeredHomework.entities.concretes.User;

public class CheckUser implements CheckEmailService {

	@Override
	public boolean checkEmail(User user,UserService service) {
		List<User> users = service.getAll();
		boolean result=true;
		for(User use : users) {
			if(use.getEmail().equals(user.getEmail())) {
				result=false;
			}
		}
		return result;
	}

}
