package com.mygroup.project.service;

import com.mygroup.project.dao.StudentDao;
import com.mygroup.project.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class StudentServiceImp implements StudentService{

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImp(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public long save(Student student) {
       return studentDao.save(student);
    }

    @Override
    public Student get(long id) {
        return studentDao.get(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Transactional
    @Override
    public Student update(long id, Student student) {
        studentDao.update(id, student);
        return student;
    }

    @Transactional
    @Override
    public Student delete(long id) {
        studentDao.delete(id);
        return studentDao.get(id);
    }

}
