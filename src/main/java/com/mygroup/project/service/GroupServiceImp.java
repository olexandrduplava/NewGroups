package com.mygroup.project.service;

import com.mygroup.project.dao.GroupDao;
import com.mygroup.project.model.Group;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GroupServiceImp implements GroupService{

    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImp(GroupDao groupDao){
        this.groupDao = groupDao;
    }

    @Transactional
    @Override
    public long save(Group group) {
        return groupDao.save(group);
    }

    @Transactional
    @Override
    public Group get(long id) {
        return groupDao.get(id);
    }

    @Transactional
    @Override
    public List<Group> list() {
        return groupDao.list();
    }

    @Transactional
    @Override
    public void update(long id, Group group) {
        groupDao.update(id, group);
    }

    @Transactional
    @Override
    public void delete(long id) {
        groupDao.delete(id);
    }

}
