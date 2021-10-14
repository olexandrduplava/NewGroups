package com.mygroup.project.dao;
//1
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

//    @Test
//    public void testSave() {
//        Student student = new Student();
//        student.setId(1L);
//        student.setFirstName("FIRST1");
//        student.setLastName("LAST1");
//        long id = studentDao.save(student);
//        Student student1 = studentDao.get(id);
//        assertEquals(student,student1);
//    }
    @Test
    public void testGet() {
    }
    @Test
    public void testList() {
    }
    @Test
    public void testUpdate() {
    }
    @Test
    public void testDelete() {
    }
}