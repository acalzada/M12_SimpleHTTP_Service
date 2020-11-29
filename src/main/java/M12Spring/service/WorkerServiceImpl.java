package M12Spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import M12Spring.dto.Worker;
import M12Spring.dao.WorkerDao;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	WorkerDao workerDao;
	
	@Override
	public List<Worker> getAllWorkers() {
		return workerDao.findAll();
	}

	@Override
	public Worker addWorker(Worker worker) {
		return workerDao.save(worker);
	}

	@Override
	public Worker getWorkerById(Long id) {
		return workerDao.findById(id).get();
	}

	@Override
	public Worker updateWorker(Worker worker) {
		return workerDao.save(worker);
	}

	@Override
	public void removeWorker(Worker worker) {
		workerDao.delete(worker);
	}

	@Override
	public List<Worker> findByJobPosition(String position) {
		return workerDao.findByJobPosition(position);
	}

}