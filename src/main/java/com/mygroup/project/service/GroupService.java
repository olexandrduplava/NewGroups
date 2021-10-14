package com.mygroup.project.service;

import com.mygroup.project.model.Group;
import org.springframework.stereotype.Repository;

import java.util.List;
//1
@Repository
public interface GroupService {

    long save(Group group);

    Group get(long id);

    List<Group> list();

    void update(long id, Group group);

    void delete(long id);

}
