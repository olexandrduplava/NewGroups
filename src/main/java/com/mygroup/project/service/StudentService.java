package com.mygroup.project.service;

import com.mygroup.project.model.Student;
import java.util.Set;

public interface StudentService {

    long save(Student student);

    Student get(long id);

    Set<Student> getAll();

    Student update(long id, Student student);

    Student delete(long id);

}
