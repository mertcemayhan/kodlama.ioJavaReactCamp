package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.TitleService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.TitleDao;
import kodlamaio.HRMS.entities.concretes.Title;

@Service
public class TitleManager implements TitleService {
	
	private TitleDao titleDao;
	
	@Autowired
	public TitleManager(TitleDao titleDao) {
		super();
		this.titleDao = titleDao;
	}


	@Override
	public DataResult<List<Title>> getAll() {
		return new SuccessDataResult<List<Title>>(this.titleDao.findAll(),"Mevcut pozisyonlar ekrandadır");

	}

}
