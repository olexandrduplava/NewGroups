package com.mygroup.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mygroup.project.config.AppConfig;
import com.mygroup.project.model.Student;
import com.mygroup.project.service.StudentService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentControllerTest{

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    String BASE_URL = "/student";

    private MockMvc mockMvc;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private ObjectMapper objectMapper;

    Student expectedStudent;

    @BeforeClass
    void init(){
        objectMapper = new ObjectMapper();
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

   @BeforeMethod
    public void setup(){
        expectedStudent = new Student(1L,"TEST","TEST");
    }

    @AfterMethod
    public void testEnd(){
        expectedStudent = null;
    }

    @Test
    public void testSave() throws Exception {
        String url = BASE_URL;
        Mockito.when(studentService.save(any(Student.class))).thenReturn(expectedStudent.getId());
        String requestJson = objectMapper.writeValueAsString(expectedStudent);
        mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1," +
                        "\"firstName\":\"TEST\"," +
                        "\"lastName\":\"TEST\"," +
                        "\"createDate\":null," +
                        "\"averageRank\":null," +
                        "\"group\":null" +
                        "}"));
        Mockito.verify(studentService, Mockito.times(1)).save(any(Student.class));
    }

   @Test
    public void testGet() throws Exception {
        String url = BASE_URL + "/" + expectedStudent.getId();
        Mockito.when(studentService.get(expectedStudent.getId())).thenReturn(expectedStudent);
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(content().string(
                        "{\"id\":1,\"firstName\":\"TEST\",\"lastName\":\"TEST\",\"createDate\":null,\"averageRank\":null,\"group\":null}"))
                .andExpect(status().isOk());
        Mockito.verify(studentService, Mockito.times(1)).get(expectedStudent.getId());
    }

    @Test
    public void testGetAll() throws Exception {

        String url = BASE_URL;
        Student student2 = new Student(2L,"TEST2","TEST2");
//        Mockito.when(studentService.getAll()).thenReturn(Arrays.asList(expectedStudent, student2));
        Mockito.when(studentService.getAll()).thenReturn(Set.of(expectedStudent, student2));
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(content().string(
                        "[{\"id\":1,\"firstName\":\"TEST\",\"lastName\":\"TEST\",\"createDate\":null,\"averageRank\":null,\"group\":null}," +
                                "{\"id\":2,\"firstName\":\"TEST2\",\"lastName\":\"TEST2\",\"createDate\":null,\"averageRank\":null,\"group\":null}]"))
                .andExpect(status().isOk());
        Mockito.verify(studentService, Mockito.times(1)).getAll();
    }

    @Test
    public void testUpdate() throws Exception {
        String url = BASE_URL + "/1";
        Mockito.when(studentService.update(eq(1L), any(Student.class))).thenReturn(expectedStudent);
        String requestJson = objectMapper.writeValueAsString(expectedStudent);
        mockMvc.perform(MockMvcRequestBuilders.put(url).contentType(APPLICATION_JSON_UTF8)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"firstName\":\"TEST\",\"lastName\":\"TEST\",\"createDate\":null,\"averageRank\":null,\"group\":null}"));
        Mockito.verify(studentService, Mockito.times(1)).update(eq(1L), any(Student.class));
    }

    @Test
    public void testDelete() throws Exception {
        String url = BASE_URL + "/" + expectedStudent.getId();
        Mockito.when(studentService.delete(expectedStudent.getId())).thenReturn(expectedStudent);
        mockMvc.perform(MockMvcRequestBuilders.delete(url))
                .andExpect(status().isNoContent());
        Mockito.verify(studentService, Mockito.times(1)).delete(expectedStudent.getId());
    }
}
