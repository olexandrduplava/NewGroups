package com.mygroup.project.dao;

import com.mygroup.project.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentDao {

    Student save(Student student);

    Student get(long id);

    List<Student> getAll();

    Student update(long id, Student student);

    void delete(long id);

}
