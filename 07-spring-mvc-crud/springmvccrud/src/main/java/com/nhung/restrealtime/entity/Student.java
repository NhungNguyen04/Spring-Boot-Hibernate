package com.nhung.restrealtime.entity;
import jakarta.persistence.*;


@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="gender")
    private String gender;

    @Column(name="career_aspiration")
    private String careerAspiration;

    //                          Constructors
    public Student() {}
    public Student(String careerAspiration, String lastName, int id, String gender, String firstName, String email) {
        this.careerAspiration = careerAspiration;
        this.lastName = lastName;
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.email = email;
    }

    //                          Setters and Getters


    public String getCareerAspiration() {
        return careerAspiration;
    }

    public void setCareerAspiration(String careerAspiration) {
        this.careerAspiration = careerAspiration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //              toString method

    @Override
    public String toString() {
        return "Student{" +
                "careerAspiration='" + careerAspiration + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
