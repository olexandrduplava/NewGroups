package com.mygroup.project.dao;

import com.mygroup.project.config.AppConfig;
import com.mygroup.project.model.Student;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class StudentDaoTest extends TestCase {

    private StudentDao studentDao;

    //TODO All my data deleted before tests

    @BeforeClass
    void init(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        studentDao = applicationContext.getBean(StudentDao.class);
    }

    @Test
    public void testSaveStudentDao() {
        Student student = new Student("First2","Last2");
        long id = studentDao.save(student);
        Student student1 = studentDao.get(id);
        assertEquals(student,student1);
        studentDao.delete(student.getId());
    }

    @Test
    public void testGetStudentDao() {
        //TODO HZ chu pravilno
        Student student = new Student("First2","Last2");
        Student student1 = studentDao.get((studentDao.save(student)));
        assertEquals(student,student1);
        studentDao.delete(student.getId());
    }

    @Test
    public void testListStudentDao() {
        Student student1 = new Student("Sasha","LastName");
        Student student2 = new Student("Alex","LastName");
        long id1 = studentDao.save(student1);
        long id2 = studentDao.save(student2);
        List<Student> actualList = studentDao.list();
        assertThat(actualList)
                .isNotNull()
                .isNotEmpty()
                .hasSizeGreaterThan(1)
                .contains(student1, student2);
        studentDao.delete(id1);
        studentDao.delete(id2);
    }

    @Test
    public void testUpdateStudentDao() {
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
    public void testDeleteStudentDao() {
        Student student = new Student("BLA","BLA");
        long id = studentDao.save(student);
        Student student1 = studentDao.get(id);
        assertEquals(student,student1);
        studentDao.delete(id);
        Student deleteStudent = studentDao.get(id);
        assertNull(deleteStudent);
    }
}