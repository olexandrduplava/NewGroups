package com.mygroup.project.dao;

import com.mygroup.project.config.AppConfig;
import com.mygroup.project.model.Group;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupDaoTest extends TestCase {

    private GroupDao groupDao;

    @BeforeClass
    void init(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        groupDao = applicationContext.getBean(GroupDao.class);
    }

    @Test
    public void testSaveGroupDao() {
        Group group = new Group("Group 1");
        long id = groupDao.save(group);
        Group group1 = groupDao.get(id);
        assertEquals(group,group1);
        groupDao.delete(group.getId());
    }

    @Test
    public void testGetGroupDao() {
        //TODO Make getGroup TEST
    }

    @Test
    public void testListGroupDao() {
        Group group1 = new Group("Group 1");
        Group group2 = new Group("Group 2");
        long id1 = groupDao.save(group1);
        long id2 = groupDao.save(group2);
        List<Group> actualList = groupDao.list();
        assertThat(actualList)
                .isNotNull()
                .isNotEmpty()
                .hasSizeGreaterThan(1)
                .contains(group1, group2);
        groupDao.delete(id1);
        groupDao.delete(id2);
    }

    @Test
    public void testUpdateGroupDao() {
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
    public void testDeleteGroupDao() {
        Group group = new Group("Group 1");
        long id = groupDao.save(group);
        Group student1 = groupDao.get(id);
        assertEquals(group,student1);
        groupDao.delete(id);
        Group deleteStudent = groupDao.get(id);
        assertNull(deleteStudent);
    }
}