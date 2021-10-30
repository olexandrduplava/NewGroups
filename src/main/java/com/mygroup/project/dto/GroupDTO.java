package com.mygroup.project.dto;

import com.mygroup.project.model.Group;
import com.mygroup.project.model.Student;

import java.time.LocalDateTime;
import java.util.List;

public class GroupDTO {

    private long id;

    private String title;

    private LocalDateTime createDate;

    private List<Student> students;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public static GroupDTO toGroupDTO(Group group){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(group.getId());
        groupDTO.setTitle(group.getTitle());
        groupDTO.setCreateDate(group.getCreateDate());
        groupDTO.setStudents(group.getStudents());
        return groupDTO;
    }
}
