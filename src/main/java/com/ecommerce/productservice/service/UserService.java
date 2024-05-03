package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dtos.GetInstructorDto;
import com.ecommerce.productservice.models.Batch;
import com.ecommerce.productservice.models.Instructor;
import com.ecommerce.productservice.models.Learner;
import com.ecommerce.productservice.models.User;
import com.ecommerce.productservice.repository.InstructorRepository;
import com.ecommerce.productservice.repository.LearnerRepository;
import com.ecommerce.productservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserService {

    private final UserRepository userRepository;

    private final InstructorRepository instructorRepository;

    private final LearnerRepository learnerRepository;

    public UserService(UserRepository userRepository, InstructorRepository instructorRepository, LearnerRepository learnerRepository) {
        this.userRepository = userRepository;
        this.instructorRepository = instructorRepository;
        this.learnerRepository = learnerRepository;
    }

//    public UserService(UserRepository userRepository) {
  //      this.userRepository = userRepository;
    //}

    public User createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    public Instructor createInstructor(String name, String email) {
        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setEmail(email);
        instructor.setSalary(20000.0);
        instructor.setSkill("Backend");
        instructorRepository.save(instructor);
        return instructor;
    }

    // Try to create Learner
    public Learner createLearner(String name, String email) {
        Learner learner = new Learner();
        learner.setName(name);
        learner.setEmail(email);
        learner.setPsp(92.82);
        learner.setUniversity("IIIT Jabalpur");
        learnerRepository.save(learner);
        return learner;
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }
    public List<GetInstructorDto> getInstructorByName(String name) {
        List<Instructor> instructors =  instructorRepository.findByName(name);
        //return instructorRepository.findByName(name);
        System.out.println(instructors.get(1).getBatch());
        //return instructors;
        for(Instructor instructor : instructors) {
            for (Batch batch : instructor.getBatch()) {
                System.out.println(batch.getName());
            }
        }
        List<GetInstructorDto> instructorDtos = new ArrayList<>();
        for(Instructor instructor : instructors) {
            GetInstructorDto getInstructorDto = new GetInstructorDto();
            getInstructorDto.setId(instructor.getId());
            getInstructorDto.setName(instructor.getName());
            getInstructorDto.setEmail(instructor.getEmail());
            List<String> batchNames = new ArrayList<>();
            List<Long> batchIds = new ArrayList<>();
            for(Batch batch : instructor.getBatch()){
                batchNames.add(batch.getName());
                batchIds.add(batch.getId());
            }
            getInstructorDto.setBatchName(batchNames);
            getInstructorDto.setBatchId(batchIds);
            instructorDtos.add(getInstructorDto);
        }
        return instructorDtos;
    }

}
