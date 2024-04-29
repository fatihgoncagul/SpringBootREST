package com.example.springbootrest;


import com.example.springbootrest.model.JobPost;
import com.example.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // it resolves the cross origin issue between frontend-backend; basically we allow this frontend to send request
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    //@ResponseBody we need to write this if we use @Controller annotation for the class
    public List<JobPost> getAllJobs(){
        // jackson library converts list of jobposts into json data (spring uses)
        //if we wanted server to accept xml we need to add dependency jackson xml
        return service.getAllJobs();// we are returning data now
        //we get a error when we had done this which is about viewresolver
        //***ViewResolver thinks by default we are returning a viewname when we use @controller annotation but we dont want that
         // so we need to use @responsebody to make spring understand we are sending json data

        // we can also use @RestController; then we dont have tp write @responsebody annotation
        //server to client
    }
    @GetMapping(path="jobPost/{postId}",produces ={"application/json"}) // we needed to add the postId in curly brackets so that we can pass the value
    public JobPost getJob(@PathVariable("postId") int postId){ // also we need to add @PathVariable in order to Spring understand plus we can pass multiple values with annotation

        return service.getJob(postId);
        //server to client
    }
    @PostMapping(path="jobPost", consumes = {"application/xml"})//we specify that it needs to take xml data. by default its json btw
    public JobPost addJob(@RequestBody JobPost jobPost){ // when you want to return data we use @ResponseBody;
        //when we want to send data or as a server if you want to accept data, we use @RequestBody; remember that this annotation takes json data and turns it into this parameter's object type so that spring can deal with it
        service.addJob(jobPost);
        //with this methhod we learned how do you send data from client to server
        return service.getJob(jobPost.getPostId());// to make sure we got it
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){

        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){

        service.deleteJob(postId);
        return "deleted";
    }


    @GetMapping("load")
    public  String loadData(){

        service.load();
        return "succes";
    }
}





