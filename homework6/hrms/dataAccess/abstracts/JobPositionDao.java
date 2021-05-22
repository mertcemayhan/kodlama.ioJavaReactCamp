package homework6.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import homework6.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{ 
	
}
