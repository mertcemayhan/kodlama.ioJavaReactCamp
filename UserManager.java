
public class UserManager{
	public void login(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "ba�ar�l� bir �ekilde giri� yapt�n�z.");
	}
	
	public void logout(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "ba�ar�l� bir �ekilde ��k�� yapt�n�z.");
	}
}
