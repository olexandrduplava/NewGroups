package com.mygroup.project.dto;

import com.mygroup.project.model.Group;
import com.mygroup.project.model.Student;

public class StudentDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Double averageRank;

    private Group group;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getAverageRank() {
        return averageRank;
    }

    public void setAverageRank(Double averageRank) {
        this.averageRank = averageRank;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public static StudentDTO toStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAverageRank(student.getAverageRank());
        studentDTO.setGroup(student.getGroup());
        return studentDTO;
    }

}
