package hello.service;

import hello.model.Job;

public interface JobService {
public String updatejob(String id,String name);
public  Iterable<Job> getAlljobs();
}

