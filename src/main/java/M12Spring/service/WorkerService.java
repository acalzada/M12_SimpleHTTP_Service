package M12Spring.service;

import java.util.List;

import M12Spring.dto.Worker;

public interface WorkerService {

	public List<Worker> getAllWorkers();
	
	public Worker addWorker(Worker worker);
	
	public Worker getWorkerById(Long id);
	
	public Worker updateWorker(Worker worker);
	
	public void removeWorker(Long id);
	
	public List<Worker> findByJobPosition(String position); 

}
