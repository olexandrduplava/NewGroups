package com.mygroup.project.service;

import com.mygroup.project.model.Group;

import java.util.List;

public interface GroupService {

    long save(Group group);

    Group get(long id);

    List<Group> getAll();

    Group update(long id, Group group);

    Group delete(long id);

}
