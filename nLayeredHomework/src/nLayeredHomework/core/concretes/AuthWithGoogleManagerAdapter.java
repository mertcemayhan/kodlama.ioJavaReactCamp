package nLayeredHomework.core.concretes;

import nLayeredHomework.authWithGoogle.GoogleManager;
import nLayeredHomework.core.abstracts.AuthWithGoogleServiceAdapter;

public class AuthWithGoogleManagerAdapter implements AuthWithGoogleServiceAdapter{

	@Override
	public void signInWithGoogle(String email, String password) {
		GoogleManager manager = new GoogleManager();
		manager.signIn(email, password);
		
	}

	@Override
	public void signUpWithGoogle(String email, String password) {
		GoogleManager manager = new GoogleManager();
		manager.signUp(email, password);
		
	}



}
