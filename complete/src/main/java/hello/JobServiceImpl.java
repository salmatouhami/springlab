package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Job;
import hello.service.JobService;
@Service
public class JobServiceImpl implements JobService {
	@Autowired
JobRepository jobrepository;
	@Override
	public String updatejob(String id, String name) {
		Job job = jobrepository.findById(id).get();
		job.setJobTitle(name);
		return "saved";
	}
	@Override
	public Iterable<Job> getAlljobs() {
 return jobrepository.findAll();	
}

}
