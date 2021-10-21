package com.mygroup.project.service;

import com.mygroup.project.model.Group;

import java.util.List;

public interface GroupService {

    long save(Group group);

    Group get(long id);

    List<Group> getAll();

    void update(long id, Group group);

    void delete(long id);

}
