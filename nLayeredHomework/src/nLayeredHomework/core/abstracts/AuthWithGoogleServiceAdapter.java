package nLayeredHomework.core.abstracts;


public interface AuthWithGoogleServiceAdapter {
	void signInWithGoogle(String email,String password);
	void signUpWithGoogle(String email,String password);
}
