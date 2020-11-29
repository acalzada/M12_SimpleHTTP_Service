package M12Spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import M12Spring.dto.Worker;

public interface WorkerDao extends JpaRepository<Worker, Long> {
	
	// Get a list of all the workers with the given job position.
	public List<Worker> findByJobPosition(String position);

}
