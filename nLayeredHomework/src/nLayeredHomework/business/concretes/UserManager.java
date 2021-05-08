package nLayeredHomework.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nLayeredHomework.business.abstracts.CheckEmailService;
import nLayeredHomework.business.abstracts.UserService;
import nLayeredHomework.core.abstracts.AuthWithGoogleServiceAdapter;
import nLayeredHomework.core.abstracts.EmailVerificationService;
import nLayeredHomework.dataAccess.abstracts.UserDao;
import nLayeredHomework.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private CheckEmailService checkEmailService;
	private AuthWithGoogleServiceAdapter adapter;
	private EmailVerificationService emailVerificationService;
	public UserManager(UserDao userDao,CheckEmailService checkEmailService,AuthWithGoogleServiceAdapter adapter,EmailVerificationService emailVerificationService) {
		super();
		this.userDao = userDao;
		this.checkEmailService = checkEmailService;
		this.adapter = adapter;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public void add(User user) {
		String pattern = "[@]";
		Pattern r=Pattern.compile(pattern);
		Matcher m=r.matcher(user.getEmail());
		if(user.getPassword().length()<6 || !m.find() || user.getFirstName().length()<2 || user.getLastName().length()<2 || !checkEmailService.checkEmail(user, this)) {
			System.out.println("Geçersiz bilgi");
		}else {
			if(emailVerificationService.verification(user.getEmail())) System.out.println("Sisteme  kayýt edildi");
			else System.out.println("Email onaylanmadý");
		}
		
	}
	@Override
	public void addWithGoogle(User user) {
		adapter.signUpWithGoogle(user.getEmail(), user.getPassword());
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void logIn(String email, String password) {
		if(userDao.get(email, password)) {
			System.out.println("Sisteme giriþ yapýldý");
		}else {
			System.out.println("Yanlýþ parola veya email girildi");
		}
		
	}

	

}
