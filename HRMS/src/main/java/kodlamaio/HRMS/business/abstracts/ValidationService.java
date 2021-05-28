package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Validation;

public interface ValidationService {
	Result verify(String validationCode,Integer id);
	void genereatedCode(Validation code, Integer id);

}