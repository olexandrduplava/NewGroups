package com.mygroup.project.service;

import com.mygroup.project.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentService {

    long save(Student student);

    Student get(long id);

    List<Student> list();

    void update(long id, Student student);

    void delete(long id);

}
