package com.mygroup.project.dao;

import com.mygroup.project.model.Student;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//TODO Replace all Transactional from methods to above Repository once

@Repository
public class StudentDaoImp implements StudentDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public long save(Student student) {
        sessionFactory.getCurrentSession().save(student);
        return student.getId();
    }

    @Transactional
    @Override
    public Student get(long id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    @Transactional
    @Override
    public List<Student> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);
        Query<Student> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void update(long id, Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student student2 = session.byId(Student.class).load(id);
        student2.setFirstName(student.getFirstName());
        student2.setLastName(student.getLastName());
        student2.setCreateDate(student.getCreateDate());
        student2.setAverageRank(student.getAverageRank());
        student2.setGroup(student.getGroup());
        session.flush();
    }

    @Transactional
    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.byId(Student.class).load(id);
        session.delete(student);
    }

}
