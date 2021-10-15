package com.mygroup.project.service;

import com.mygroup.project.config.AppConfig;
import com.mygroup.project.model.Student;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentServiceTest extends TestCase {

    private StudentService studentService;

    @BeforeClass
    void init(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        studentService = applicationContext.getBean(StudentService.class);
    }

    @Test
    public void testSaveStudentService() {

    }

    @Test
    public void testGetStudentService() {
    }

    @Test
    public void testListStudentService() {

    }

    @Test
    public void testUpdateStudentService() {

    }

    @Test
    public void testDeleteStudentService() {

    }
}