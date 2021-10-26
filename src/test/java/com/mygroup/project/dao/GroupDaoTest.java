//package com.mygroup.project.dao;
//
//import com.mygroup.project.config.AppConfig;
//import com.mygroup.project.config.WebConfig;
//import com.mygroup.project.model.Group;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {
//        AppConfig.class,
//        WebConfig.class
//})
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//
//public class GroupDaoTest {
//
//    private GroupDao groupDao;
//
//    @BeforeClass
//    void init(){
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        groupDao = applicationContext.getBean(GroupDao.class);
//    }
//
//    @Test
//    public void testSaveGroupDao() {
//        Group expected = new Group("Group 1");
//        long id = groupDao.save(expected);
//        Group actual = groupDao.get(id);
//
//        System.out.println("=============== GroupDao Save ===============");
//        System.out.println("expected: " + expected);
//        System.out.println("actual: " + actual);
//        System.out.println("================================================");
//
//        Assert.assertEquals(expected,actual);
//        groupDao.delete(expected.getId());
//
//    }
//
//    @Test
//    public void testGetGroupDao() {
//        Group expected = new Group("First2");
//        Group actual = groupDao.get((groupDao.save(expected)));
//        Assert.assertEquals(expected,actual);
//
//        System.out.println("=============== GroupDao Get ===============");
//        System.out.println("expected: " + expected);
//        System.out.println("actual: " + actual);
//        System.out.println("==================================================");
//
//        groupDao.delete(expected.getId());
//    }
//
//    @Test
//    public void testListGroupDao() {
//        Group group1 = new Group("Group 1");
//        Group group2 = new Group("Group 2");
//        long id1 = groupDao.save(group1);
//        long id2 = groupDao.save(group2);
//        List<Group> actualList = groupDao.getAll();
//        assertThat(actualList)
//                .isNotNull()
//                .isNotEmpty()
//                .hasSizeGreaterThan(1)
//                .contains(group1, group2);
//
//        System.out.println("=============== GroupDao List ===============");
//        System.out.println("Actual List: " + actualList);
//        System.out.println("==================================================");
//
//        groupDao.delete(id1);
//        groupDao.delete(id2);
//    }
//
//    @Test
//    public void testUpdateGroupDao() {
//        Group group = new Group("Group 1");
//        long id = groupDao.save(group);
//        Group group1 = groupDao.get(id);
//        group1.setTitle("Group 2");
//        groupDao.update(id,group1);
//        Group group2 = groupDao.get(id);
//        Assert.assertEquals(group1, group2);
//
//        System.out.println("=============== GroupDao Update ===============");
//        System.out.println("group: " + group);
//        System.out.println("expected: " + group1);
//        System.out.println("actual: " + group2);
//        System.out.println("====================================================");
//
//        groupDao.delete(id);
//    }
//
//    @Test
//    public void testDeleteGroupDao() {
//        Group group = new Group("Group 1");
//        long id = groupDao.save(group);
//
//        System.out.println("=============== GroupDao Delete ===============");
//        System.out.println("group: " + group);
//
//        groupDao.delete(id);
//        Group deleteStudent = groupDao.get(id);
//        Assert.assertNull(deleteStudent);
//
//        Group isNull = groupDao.get(id);
//        System.out.println("groupById: " + isNull);
//        System.out.println("====================================================");
//    }
//}