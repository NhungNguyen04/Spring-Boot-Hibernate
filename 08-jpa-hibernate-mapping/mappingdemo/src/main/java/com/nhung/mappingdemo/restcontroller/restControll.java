package com.nhung.mappingdemo.restcontroller;

import com.nhung.mappingdemo.DTO.InstructorDTO;
import com.nhung.mappingdemo.Entity.Instructor;
import com.nhung.mappingdemo.Entity.InstructorDetail;
import com.nhung.mappingdemo.dao.AppDAO;
import com.nhung.mappingdemo.dao.AppDAOImpl;
import com.nhung.mappingdemo.repository.InstructorDetailRepository;
import com.nhung.mappingdemo.repository.InstructorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restControll {

    private final InstructorRepository instructorRepository;
    private final InstructorDetailRepository instructorDetailRepository;

    public restControll(InstructorRepository instructorRepository, InstructorDetailRepository instructorDetailRepository) {
        this.instructorRepository = instructorRepository;
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @PostMapping("/instructors")
    public ResponseEntity <Instructor> createInstructor(@RequestBody InstructorDTO instructorDTO) {

        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorDTO.getFirstName());
        instructor.setLastName(instructorDTO.getLastName());
        instructor.setEmail(instructorDTO.getEmail());

        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setHobby(instructorDTO.getInstructorDetailDTO().getHobby());
        instructorDetail.setYoutubeChannel(instructorDTO.getInstructorDetailDTO().getYoutubeChannel());



        instructorDetail.setInstructor(instructor);
        instructor.setInstructorDetailId(instructorDetail);

        instructorRepository.save(instructor);
        instructorDetailRepository.save(instructorDetail);

        return ResponseEntity.ok(instructor);
    }
}
