package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.business.abstracts.ValidationService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.Employer;
import kodlamaio.HRMS.entities.concretes.User;
import kodlamaio.HRMS.entities.concretes.Validation;


@Service
public class EmployerManager  implements EmployerService{
	
	private EmployerDao employerDao;
	private UserService userService;
	private ValidationService validationService;
	
	public  EmployerManager(EmployerDao employerDao, UserService userService, ValidationService validationService) {
		super();
		this.employerDao = employerDao;
		this.userService = userService;
		this.validationService = validationService;
		
	}
	

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Ä°ÅŸverenler listesi baÅŸarÄ±yla getirildi");
	}

	@Override
	public DataResult<Employer> add(Employer employer) {
		
		if(!companyNameCheck(employer)) {
			
			return new ErrorDataResult<Employer>(null,"Lutfen sirket ismi giriniz");
			
		}else if(!webAddressCheck(employer)) {
			
			return new ErrorDataResult<Employer>(null,"Lutfen sirketinize ait wen adresini giriniz");
			
		}else if(!phoneNumberCheck(employer.getPhoneNumber())) {
			
			return new ErrorDataResult<Employer>(null, "Telefon numaranizi dogru bir sekilde giriniz");
			
		}else if(!isEmailFormat(employer.getEmail())) {
			
			return new ErrorDataResult<Employer>(null,"Email adresinizi dogru giriniz");
			
		}else if(!employerRegister(employer)) {
			
			return new ErrorDataResult<Employer>(null, "Bu email daha onceden kayıt olmustur");
		}else if(!passwordCheck(employer)) {
			return new ErrorDataResult<Employer>(null,"Sifreniz gecersizdir. Tekrar giriniz");
		}
		
		User saveUser = this.userService.add(employer);
		this.validationService.genereatedCode(new Validation(), saveUser.getId());
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),"Hesabinizin onaylamnmasi icin email adresinizi kontrol ediniz");
				
		

	}
	
	private boolean companyNameCheck(Employer employer) {
		
		if(employer.getWebAddress().isBlank()&& employer.getWebAddress()==null) {
			
			return false;
		}
		return true;
	}
	
	private boolean webAddressCheck(Employer employer) {
		if(employer.getWebAddress().isBlank() && employer.getWebAddress()==null) {
			return false;
		}
		return true;
	}
	
	private boolean phoneNumberCheck(String phoneNumber) {
		String patterns ="^(05)([0-9]{2})\s?([0-9]{3})\s?([0-9]{2})\s?([0-9]{2})$";

	  
		
		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();

	}
	
	

		  public boolean isEmailFormat(String emailFormat) {

	            String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

	            Pattern pattern = Pattern.compile(regex);
	            Matcher matcher = pattern.matcher(emailFormat);
	            return matcher.matches();
	}
	
	private boolean employerRegister(Employer employer) {
		if(employerDao.getAllByEmail(employer.getEmail()).stream().count() !=0) {
			return false;
		}
		return true;
	}
	
	private boolean passwordCheck(Employer employer) {
		if(employer.getPassword()==null && employer.getPassword().isEmpty()) {
			return false;
		}
		return true;
	}

}
