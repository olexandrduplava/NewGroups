package com.mygroup.project.dao;

import com.mygroup.project.model.Group;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface GroupDao {

    long save(Group group);

    Group get(long id);

    List<Group> getAll();

    void update(long id, Group group);

    void delete(long id);

}
