package com.nhung.mappingdemo.DTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class InstructorDTO {
    private String firstName;
    private String lastName;
    private String email;

    private InstructorDetailDTO instructorDetailDTO;
    private String instructorDetailUrl;

    public String getInstructorDetailUrl() {
        return instructorDetailUrl;
    }

    public void setInstructorDetailUrl(String instructorDetailUrl) {
        this.instructorDetailUrl = instructorDetailUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String address) {
        this.email = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public InstructorDetailDTO getInstructorDetailDTO() {
        return instructorDetailDTO;
    }

    public void setInstructorDetailDTO(InstructorDetailDTO instructorDetailDTO) {
        this.instructorDetailDTO = instructorDetailDTO;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

