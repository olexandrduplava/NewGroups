package com.mygroup.project.service;

import com.mygroup.project.model.Student;

import java.util.List;

public interface StudentService {

    long save(Student student);

    Student get(long id);

    List<Student> list();

    void update(long id, Student student);

    void delete(long id);

}
