package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> getAllByActiveTrue();
	
	DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId);
		
	Result setAdvertisementInactive(int advertisementId);
	
	Result add(JobAdvertisement jobAdvertisement);
	}
