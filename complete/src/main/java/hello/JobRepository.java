package hello;

import org.springframework.data.repository.CrudRepository;

import hello.model.Job;

public interface JobRepository extends CrudRepository<Job, String>{

}
