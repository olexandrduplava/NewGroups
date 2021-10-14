package com.mygroup.project.dao;

import com.mygroup.project.model.Group;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupDao {

    long save(Group group);

    Group get(long id);

    List<Group> list();

    void update(long id, Group group);

    void delete(long id);

}
