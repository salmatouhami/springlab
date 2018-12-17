package hello;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Country;
import hello.model.Job;
import hello.service.JobService;


@Controller    
@RequestMapping(path="/demo")
public class MainController {
	@Autowired
	CountryRepository countryrepository;
	
	JobService jobservice;
	@Autowired
	public void setJobservice(JobService jobservice) {
		this.jobservice = jobservice;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Country> getAllUsers() {
		return countryrepository.findAll();
	}
	@GetMapping(path="/jobs/all")
	public @ResponseBody Iterable<Job> getAlljobs() {
		return jobservice.getAlljobs();
	}
	
	@PostMapping(path="/jobs")
	public @ResponseBody String updatejob(@RequestParam(name="id", required=true) String id,@RequestParam(name="name", required=true) String newname){
	return jobservice.updatejob(id, newname);
	}
}
