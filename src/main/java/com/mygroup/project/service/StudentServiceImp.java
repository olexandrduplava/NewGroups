package com.mygroup.project.service;


import com.mygroup.project.dao.StudentDao;
import com.mygroup.project.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class StudentServiceImp implements StudentService{

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImp(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    @Transactional
    @Override
    public long save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student get(long id) {
        return studentDao.get(id);
    }

    @Override
    public List<Student> list() {
        return studentDao.list();
    }

    @Transactional
    @Override
    public void update(long id, Student student) {
        studentDao.update(id, student);
    }

    @Transactional
    @Override
    public void delete(long id) {
        studentDao.delete(id);
    }

}
