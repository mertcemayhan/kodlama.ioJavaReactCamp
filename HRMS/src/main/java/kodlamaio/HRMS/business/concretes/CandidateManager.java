package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.business.abstracts.ValidationService;
import kodlamaio.HRMS.core.utilities.adapters.MernisCheckManager;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.User;
import kodlamaio.HRMS.entities.concretes.Validation;

@Service
public class CandidateManager implements CandidateService {
	@Autowired
	private CandidateDao candidateDao;
	private ValidationService validationService;
	private UserService userService;

	public CandidateManager(CandidateDao candidateDao, ValidationService validationService,
			UserService userService) {
		super();
		this.candidateDao = candidateDao;
		this.validationService = validationService;
		this.userService = userService;

	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),
				"Is Adaylari Basarili bir sekildie listelendi");
	}

	@Override
	public DataResult<Candidate> add(Candidate candidate) {
		if (!firstNameChecker(candidate)) {
			
			return new ErrorDataResult<Candidate>(null, "Isım kismini doldurunuz");

		} else if (!lastNameChecker(candidate)) {
			
			return new ErrorDataResult<Candidate>(null, "Soyadi kismini doldurunuz");
			
		} else if (!MernisCheckManager.isRealPerson(candidate.getIdentityNumber())) {
			
			return new ErrorDataResult<Candidate>(null, "Gecersiz kimlik bilgileri");
			
		}else if(candidate.getIdentityNumber().isBlank()) {
			
			return new  ErrorDataResult<Candidate>(null,"TCKN alanini doldurunuz");
			
		}else if(!birthDateChecker(candidate)) {
			
			return new ErrorDataResult<Candidate>(null,"Dogum tarihinizi giriniz");
		}
		
		else if(!emailNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Email adresinizi giriniz");
		}
		else if(!isRealEmail(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Email adresinizi dogru bir sekilde giriniz");
		}
		
		else if(!passwordNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null,"Sifrenizi giriniz");
		}
		
		else if(candidateDao.findAllByEmail(candidate.getEmail()).stream().count() !=0  ) {
			return new ErrorDataResult<Candidate>(null,"Bu email zaten kayitli");
		} 
		else if(candidateDao.findAllByIdentityNumber(candidate.getIdentityNumber()).stream().count() !=0) {
			return new ErrorDataResult<Candidate>(null,"Bu TCKN zaten kayitli");
		}
		User savedUser = this.userService.add(candidate);
		this.validationService.genereatedCode(new Validation(), savedUser.getId());
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate),"Islem basarili. Lutfen email adresini dogrulayiniz"+candidate.getId());


	}

	private boolean firstNameChecker(Candidate candidate) {
		if (candidate.getFirstName().isBlank() || candidate.getFirstName().equals(null)) {
			return false;
		}
		return true;

	}

	private boolean lastNameChecker(Candidate candidate) {
		if (candidate.getLastName().isBlank() || candidate.getLastName().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean birthDateChecker(Candidate candidate) {
		if (candidate.getDateOfBirth().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean emailNullChecker(Candidate candidate) {
		if (candidate.getEmail().isBlank() || candidate.getEmail().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean passwordNullChecker(Candidate candidate) {
		if (candidate.getPassword().isBlank() || candidate.getPassword().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean isRealEmail(Candidate candidate) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(candidate.getEmail());
		if (!matcher.matches()) {
			return false;
		}
		return true;

	}

}
