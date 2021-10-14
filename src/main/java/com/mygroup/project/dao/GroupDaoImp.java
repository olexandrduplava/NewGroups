package com.mygroup.project.dao;

import java.util.List;
//1
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.mygroup.project.model.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImp implements GroupDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public GroupDaoImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long save(Group group) {
        sessionFactory.getCurrentSession().save(group);
        return group.getId();
    }

    @Override
    public Group get(long id) {
        return sessionFactory.getCurrentSession().get(Group.class, id);
    }

    @Override
    public List<Group> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Group> cq = cb.createQuery(Group.class);
        Root<Group> root = cq.from(Group.class);
        cq.select(root);
        Query<Group> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(long id, Group group) {
        Session session = sessionFactory.getCurrentSession();
        Group group2 = session.byId(Group.class).load(id);
        group2.setTitle(group.getTitle());
        group2.setStudents(group.getStudents());
        group2.setCreateDate(group.getCreateDate());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Group group = session.byId(Group.class).load(id);
        session.delete(group);
    }

}
