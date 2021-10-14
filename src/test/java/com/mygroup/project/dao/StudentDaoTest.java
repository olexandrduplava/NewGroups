package com.mygroup.project.dao;

import com.mygroup.project.config.AppConfig;
import com.mygroup.project.model.Student;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StudentDaoTest extends TestCase {

    private StudentDao studentDao;

    @BeforeClass
    void init(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        studentDao = applicationContext.getBean(StudentDao.class);
    }

    @Test
    public void testSave() {
        Student student = new Student("First2","Last2");
        long id = studentDao.save(student);
        Student student1 = studentDao.get(id);
        assertEquals(student,student1);
        studentDao.delete(student.getId());
    }

//    @Test
//    public void testGet() {
//        //TODO All my data deleted before tests
//        Student student = new Student("Alex","First");
//        Student student1 = studentDao.get(1);
//        assertEquals(student,student1);
//    }

    @Test
    public void testList() {
        //TODO make List<Student> TEST
    }

    @Test
    public void testUpdate() {
        Student student = new Student("Ivan","Third");
        long id = studentDao.save(student);
        Student student1 = studentDao.get(id);
        student1.setFirstName("Navi");
        student1.setLastName("Third");
        studentDao.update(id,student1);
        Student student2 = studentDao.get(id);
        assertEquals(student1, student2);
        studentDao.delete(id);
    }
    @Test
    public void testDelete() {
        Student student = new Student("BLA","BLA");
        long id = studentDao.save(student);
        Student student1 = studentDao.get(id);
        assertEquals(student,student1);
        studentDao.delete(id);
        Student deleteStudent = studentDao.get(id);
        assertNull(deleteStudent);
    }
}