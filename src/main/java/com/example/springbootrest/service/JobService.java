package com.example.springbootrest.service;


import com.example.springbootrest.model.JobPost;
import com.example.springbootrest.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepo repo;

    public void addJob(JobPost jobPost) { //we want to add jobPost, we are accepting with parameter
        repo.save(jobPost);
    }
    //job controller needs to pass the jobPost to the service object in the handleForm method
    //from service it will go to repo and repo is acccepting it,
    //this kind of objects are called DTOs aka data transfer objects

    public List<JobPost> getAllJobs() {

        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }


    public void updateJob(JobPost jobPost) {
        //logg
        //sec
        //validation
        //exception
        //too many lines of code needed
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {

        repo.deleteById(postId);
    }

    public void load() {


        List<JobPost> jobs = new ArrayList<>(List.of(


                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

                // Frontend Developer Job Post

                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML", "CSS", "JavaScript", "React")),

                // Data Scientist Job Post
                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),

                // Network Engineer Job Post
                new JobPost(4, "Network Engineer",
                        "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),

                // Mobile App Developer Job Post
                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
                        3, List.of("iOS Development", "Android Development", "Mobile App")),

                // DevOps Engineer Job Post

                new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
                        4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes"))


                ));

        repo.saveAll(jobs);

    }


    public List<JobPost> search(String keyword) {

       return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}