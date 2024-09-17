package com.nhung.mappingdemo.restcontroller;

import com.nhung.mappingdemo.DTO.InstructorDTO;
import com.nhung.mappingdemo.Entity.Instructor;
import com.nhung.mappingdemo.Entity.InstructorDetail;
import com.nhung.mappingdemo.dao.AppDAO;
import com.nhung.mappingdemo.dao.AppDAOImpl;
import com.nhung.mappingdemo.repository.InstructorDetailRepository;
import com.nhung.mappingdemo.repository.InstructorRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/instructor-details/{id}")
    public ResponseEntity<?> deleteInstructorDetail(@PathVariable Integer id) {
        InstructorDetail instructorDetail = instructorDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("InstructorDetail not found"));

        // Ensure the association with Instructor is broken
        Instructor instructor = instructorRepository.findByInstructorDetailId(id);
        if (instructor != null) {
            instructor.setInstructorDetailId(null);
            instructorRepository.save(instructor);
        }

        instructorDetailRepository.delete(instructorDetail);
        return ResponseEntity.ok("Instructor Detail deleted successfully");
    }

}
