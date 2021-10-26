package com.mygroup.project.service;

import com.mygroup.project.model.Student;

import java.util.List;

public interface StudentService {

    long save(Student student);

    Student get(long id);

    List<Student> getAll();

    Student update(long id, Student student);

    Student delete(long id);

}
