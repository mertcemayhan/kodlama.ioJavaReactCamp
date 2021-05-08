package nLayeredHomework.core.concretes;

import nLayeredHomework.core.abstracts.EmailVerificationService;

public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public boolean verification(String email) {
		return true;
		
	}

}
