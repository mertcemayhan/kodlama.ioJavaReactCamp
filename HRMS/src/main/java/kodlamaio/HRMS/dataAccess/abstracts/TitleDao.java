package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.HRMS.entities.concretes.Title;

public interface TitleDao extends JpaRepository <Title, Integer>{

}
