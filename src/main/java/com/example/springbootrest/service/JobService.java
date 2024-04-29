package com.example.springbootrest.service;


import com.example.springbootrest.model.JobPost;
import com.example.springbootrest.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

   @Autowired
   JobRepo repo;

    public void addJob(JobPost jobPost){ //we want to add jobPost, we are accepting with parameter
        repo.addJob(jobPost);
    }
    //job controller needs to pass the jobPost to the service object in the handleForm method
    //from service it will go to repo and repo is acccepting it,
    //this kind of objects are called DTOs aka data transfer objects

    public List<JobPost> getAllJobs(){

        return repo.getAllJobs();
    }

    public JobPost getJob(int postId){
        return repo.getJob(postId);
    }


    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }

    public void deleteJob(int postId) {

        repo.deleteJob(postId);
    }
}
