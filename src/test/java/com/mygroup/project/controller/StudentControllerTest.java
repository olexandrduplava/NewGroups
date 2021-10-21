//package com.mygroup.project.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.mygroup.project.config.AppConfig;
//import com.mygroup.project.dao.StudentDao;
//import com.mygroup.project.model.Student;
//import com.mygroup.project.service.StudentService;
//import com.mygroup.project.service.StudentServiceImp;
//import junit.framework.TestCase;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.http.RequestEntity.post;
//
//@RunWith(SpringRunner.class)
//@WebAppConfiguration
//public class StudentControllerTest{
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private StudentService studentService;
//
//    @InjectMocks
//    private StudentController studentController;
//
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void testSave() {
//
//    }
//
//    @Test
//    public void testGet() {
//
//    }
//
//    @Test
//    public void testList(){
//    }
//
//    @Test
//    public void testUpdate() {
//    }
//
//    @Test
//    public void testDelete() {
//    }
//}