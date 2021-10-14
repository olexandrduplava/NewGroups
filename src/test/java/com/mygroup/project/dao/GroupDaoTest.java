package com.mygroup.project.dao;

import com.mygroup.project.config.AppConfig;
import com.mygroup.project.model.Group;
import com.mygroup.project.model.Student;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupDaoTest extends TestCase {

    private GroupDao groupDao;

    @BeforeClass
    void init(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        groupDao = applicationContext.getBean(GroupDao.class);
    }

    @Test
    public void testSave() {
        Group group = new Group("Group 1");
        long id = groupDao.save(group);
        Group group1 = groupDao.get(id);
        assertEquals(group,group1);
        groupDao.delete(group.getId());
    }

    @Test
    public void testGet() {
        //TODO Make getGroup TEST
    }

    @Test
    public void testList() {
        //TODO Make getListGroup TEST
    }

    @Test
    public void testUpdate() {
        Group group = new Group("Group 1");
        long id = groupDao.save(group);
        Group group1 = groupDao.get(id);
        group1.setTitle("Group 2");
        groupDao.update(id,group1);
        Group group2 = groupDao.get(id);
        assertEquals(group1, group2);
        groupDao.delete(id);
    }

    @Test
    public void testDelete() {
        Group group = new Group("Group 1");
        long id = groupDao.save(group);
        Group student1 = groupDao.get(id);
        assertEquals(group,student1);
        groupDao.delete(id);
        Group deleteStudent = groupDao.get(id);
        assertNull(deleteStudent);
    }
}