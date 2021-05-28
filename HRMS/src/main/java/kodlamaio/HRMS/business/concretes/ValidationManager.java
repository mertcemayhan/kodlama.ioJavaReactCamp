package kodlamaio.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ValidationService;
import kodlamaio.HRMS.core.utilities.adapters.RandomGenerateCode;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.ValidationDao;
import kodlamaio.HRMS.entities.concretes.Validation;

@Service
public class ValidationManager implements ValidationService {

	private ValidationDao validationDao;

	@Autowired
	public ValidationManager(ValidationDao valiationDao) {
		super();
		this.validationDao = validationDao;
	}

	@Override
	public void genereatedCode(Validation code, Integer id) {
		Validation codes = code;
		codes.setCode(null);
		codes.setVerified(false);
		if (codes.isVerified() == false) {
			RandomGenerateCode generator = new RandomGenerateCode();
			String code_create = generator.create();
			codes.setCode(code_create);
			

			validationDao.save(codes);
		}
		return;

	}

	@Override
	public Result verify(String validation, Integer id) {
		Validation valid = validationDao.getOne(id);
		if (valid.getCode().equals(validation)) {
			valid.setVerified(true);
			return new SuccessDataResult<Validation>(this.validationDao.save(valid), "Kayit basarili");
		}
		return new ErrorDataResult<Validation>(null, "Dogrulama kodu gecersiz");
	}

}
