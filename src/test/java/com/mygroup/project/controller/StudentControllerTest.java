package com.mygroup.project.controller;

import com.mygroup.project.config.AppConfig;
import com.mygroup.project.model.Student;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StudentControllerTest extends TestCase {

    private StudentController studentController;

    @BeforeClass
    void init(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        studentController = applicationContext.getBean(StudentController.class);
    }

    @Test
    public void testSave() {
        //TODO Make testSave TEST for Controller
//        Student student = new Student("First2","Last2");
//        long id = studentController.save(student);
//        Student student1 = studentController.get(id);
//        assertEquals(student,student1);
//        studentController.delete(student.getId());
    }

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