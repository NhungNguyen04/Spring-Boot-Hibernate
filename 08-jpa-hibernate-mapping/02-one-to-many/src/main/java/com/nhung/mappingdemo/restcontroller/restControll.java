package com.nhung.mappingdemo.restcontroller;

import com.nhung.mappingdemo.DTO.InstructorDTO;
import com.nhung.mappingdemo.Entity.Course;
import com.nhung.mappingdemo.Entity.Instructor;
import com.nhung.mappingdemo.Entity.InstructorDetail;
import com.nhung.mappingdemo.dao.AppDAO;
import com.nhung.mappingdemo.dao.AppDAOImpl;
import com.nhung.mappingdemo.repository.CourseRepository;
import com.nhung.mappingdemo.repository.InstructorDetailRepository;
import com.nhung.mappingdemo.repository.InstructorRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class restControll {

    private final InstructorRepository instructorRepository;
    private final InstructorDetailRepository instructorDetailRepository;
    private final CourseRepository courseRepository;

    public restControll(InstructorRepository instructorRepository, InstructorDetailRepository instructorDetailRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.instructorDetailRepository = instructorDetailRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorRepository.findAll();
        return ResponseEntity.ok(instructors);
    }

    @PostMapping("/instructors&details")
    public ResponseEntity <Instructor> createInstructor(@RequestBody InstructorDTO instructorDTO) {


        Instructor instructor = new Instructor();
        instructor.setFirstName(instructorDTO.getFirstName());
        instructor.setLastName(instructorDTO.getLastName());
        instructor.setEmail(instructorDTO.getEmail());

        if (instructorDTO.getInstructorDetailDTO() !=null) {
            InstructorDetail instructorDetail = new InstructorDetail();
            instructorDetail.setHobby(instructorDTO.getInstructorDetailDTO().getHobby());
            instructorDetail.setYoutubeChannel(instructorDTO.getInstructorDetailDTO().getYoutubeChannel());
            instructorDetail.setInstructor(instructor);
            instructorDetailRepository.save(instructorDetail);
        }

        instructor.setInstructorDetailId(null);

        instructorRepository.save(instructor);

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

    @PatchMapping("/instructors/{id}/courses/{courseId}")
    public ResponseEntity<?> addCourse (@PathVariable Integer id, @PathVariable Integer courseId) {

        Course theCourse = courseRepository.findByCourseId(courseId);
        Instructor instructor = instructorRepository.findByInstructorId(id);
        if (theCourse != null && instructor != null) {
            instructor.addCourse(theCourse);
            instructorRepository.save(instructor);
            theCourse.setInstructor(instructor);
            courseRepository.save(theCourse);
            return ResponseEntity.ok(instructor);
        } else {
            return ResponseEntity.ok("Course not found");
        }
    }
}
