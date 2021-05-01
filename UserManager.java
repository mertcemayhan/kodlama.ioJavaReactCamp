
public class UserManager{
	public void login(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "baþarýlý bir þekilde giriþ yaptýnýz.");
	}
	
	public void logout(User user) {
		System.out.println(user.getFirstName()+user.getLastName()+ "baþarýlý bir þekilde çýkýþ yaptýnýz.");
	}
}
