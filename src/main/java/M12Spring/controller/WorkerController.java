package M12Spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import M12Spring.dto.Worker;
import M12Spring.service.WorkerServiceImpl;



@RestController
@RequestMapping("/")
public class WorkerController {

	@Autowired
	WorkerServiceImpl workerService;
	
	@GetMapping("/workers")
	public List<Worker> getWorkersList() {
		return workerService.getAllWorkers();
	}
	
	@GetMapping("/workers/{id}")
	public Worker getWorker(@PathVariable(name="id") Long id) {
		return workerService.getWorkerById(id);
	}
	
	@PostMapping("/workers")
	public Worker newWorker(@RequestBody Worker worker) {
		return workerService.addWorker(worker);
	}
	
	@GetMapping("/workers/job/{jobPosition}")
	public List<Worker> getWorkersByJob(@PathVariable(name="jobPosition")String jobPosition){
		return workerService.findByJobPosition(jobPosition);
	}
}
