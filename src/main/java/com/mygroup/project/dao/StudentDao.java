package com.mygroup.project.dao;

import com.mygroup.project.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    long save(Student student);

    Student get(long id);

    List<Student> getAll();

    void update(long id, Student student);

    void delete(long id);

}
