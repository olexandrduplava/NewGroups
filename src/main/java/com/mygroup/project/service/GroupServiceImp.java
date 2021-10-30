package com.mygroup.project.service;

import com.mygroup.project.dao.GroupDao;
import com.mygroup.project.model.Group;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class GroupServiceImp implements GroupService{

    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImp(GroupDao groupDao){
        this.groupDao = groupDao;
    }

    @Override
    @Transactional
    public Group save(Group group) {
        groupDao.save(group);
        return group;
    }

    @Override
    public Group get(long id) {
        return groupDao.get(id);
    }

    @Override
    public List<Group> getAll() {
        return groupDao.getAll();
    }

    @Transactional
    @Override
    public Group update(long id, Group group) {
        groupDao.update(id, group);
        return group;
    }

    @Transactional
    @Override
    public void delete(long id) {
        groupDao.delete(id);
    }

}
