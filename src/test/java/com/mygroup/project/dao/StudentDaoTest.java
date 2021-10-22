// //TODO How to test DAO https://howtodoinjava.com/best-practices/how-you-should-unit-test-dao-layer/
//package com.mygroup.project.dao;
//
//import com.mygroup.project.config.AppConfig;
//import com.mygroup.project.config.WebConfig;
//import com.mygroup.project.dao.StudentDao;
//import com.mygroup.project.model.Student;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.transaction.annotation.Transactional;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.List;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {
//        AppConfig.class,
//        WebConfig.class
//})
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class StudentDaoTest {
//
//    private StudentDao studentDao;
//
//    @BeforeClass
//    void init(){
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        studentDao = applicationContext.getBean(StudentDao.class);
//    }
//
//    @Test
//    public void testSaveStudentDao() {
//        Student expected = new Student("First2","Last2");
//        long id = studentDao.save(expected);
//        Student actual = studentDao.get(id);
//        Assert.assertEquals(expected,actual);
//
//        System.out.println("=============== StudentDao Save ===============");
//        System.out.println("expected: " + expected);
//        System.out.println("actual: " + actual);
//        System.out.println("==================================================");
//
//        studentDao.delete(expected.getId());
//    }
//
//    @Test
//    public void testGetStudentDao() {
//        Student expected = new Student("First2","Last2");
//        Student actual = studentDao.get((studentDao.save(expected)));
//        Assert.assertEquals(expected,actual);
//
//        System.out.println("=============== StudentDao Get ===============");
//        System.out.println("expected: " + expected);
//        System.out.println("actual: " + actual);
//        System.out.println("==================================================");
//
//        studentDao.delete(expected.getId());
//    }
//
//    @Test
//    public void testListStudentDao() {
//        Student student1 = new Student("Sasha","LastName");
//        Student student2 = new Student("Alex","LastName");
//        long id1 = studentDao.save(student1);
//        long id2 = studentDao.save(student2);
//        List<Student> actualList = studentDao.getAll();
//        assertThat(actualList)
//                .isNotNull()
//                .isNotEmpty()
//                .hasSizeGreaterThan(1)
//                .contains(student1, student2);
//
//        System.out.println("=============== StudentDao List ===============");
//        System.out.println("Actual List: " + actualList);
//        System.out.println("==================================================");
//
//        studentDao.delete(id1);
//        studentDao.delete(id2);
//    }
//
//    @Test
//    public void testUpdateStudentDao() {
//        Student student = new Student("Ivan","Third");
//        long id = studentDao.save(student);
//        Student student1 = studentDao.get(id);
//        student1.setFirstName("Navi");
//        student1.setLastName("Third");
//        studentDao.update(id,student1);
//        Student student2 = studentDao.get(id);
//        Assert.assertEquals(student1, student2);
//
//        System.out.println("=============== StudentDao Update ===============");
//        System.out.println("student: " + student);
//        System.out.println("expected: " + student1);
//        System.out.println("actual: " + student2);
//        System.out.println("====================================================");
//
//        studentDao.delete(id);
//    }
//
//    @Test
//    public void testDeleteStudentDao() {
//        Student student = new Student("BLA","BLA");
//        long id = studentDao.save(student);
//
//        System.out.println("=============== StudentDao Delete ===============");
//        System.out.println("student: " + student);
//
//        studentDao.delete(id);
//        Student deleteStudent = studentDao.get(id);
//        Assert.assertNull(deleteStudent);
//
//        Student isNull = studentDao.get(id);
//        System.out.println("studentById: " + isNull);
//        System.out.println("====================================================");
//    }
//}