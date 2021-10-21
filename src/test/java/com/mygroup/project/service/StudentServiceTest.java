package com.mygroup.project.service;

import com.mygroup.project.dao.StudentDao;
import com.mygroup.project.model.Student;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @Mock
    private StudentDao studentDao;
    private StudentService studentService;

    @BeforeMethod
    void init(){
        MockitoAnnotations.initMocks(this);
        studentService = new StudentServiceImp(studentDao);
    }

    @Test
    public void testtesttest(){

        Student student = new Student();
        student.setId(1L);
        student.setFirstName("AAA");
        student.setLastName("BBB");
        student.setAverageRank(5D);
        when(studentService.get(anyLong())).thenReturn(student);

    }

    @Test
    public void testSaveStudentService() {
        long expectedId = 1;
        Student student = new Student("Save", "Student");
        when(studentDao.save(student)).thenReturn(expectedId);
        long actualId = studentDao.save(student);
        verify(studentDao).save(student);
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void testGetStudentService() {
        long expectedId = 1;
        Student student = new Student("Get", "Student");
        when(studentDao.get(expectedId)).thenReturn(student);
        Student expectedStudent = studentService.get(expectedId);
        verify(studentDao).get(expectedId);
        Assert.assertEquals(student, expectedStudent);
    }

    @Test
    public void testListStudentService() {
        Student student1 = new Student("List1", "Student");
        Student student2 = new Student("List2", "Student");
        List<Student> actualList = Arrays.asList(student1, student2);
        when(studentDao.getAll()).thenReturn(actualList);
        List<Student> expectedList = studentService.getAll();
        verify(studentDao).getAll();
        assertThat(expectedList)
                .isNotNull()
                .isNotEmpty()
                .hasSizeGreaterThan(1)
                .contains(student1, student2);
    }

    @Test
    public void testUpdateStudentService() {
        long expectedId = 1;
        Student student = new Student("Update", "Service");
        when(studentDao.save(student)).thenReturn(expectedId);
        doNothing().when(studentDao).update(expectedId, student);
        studentService.update(expectedId, student);
        verify(studentDao).update(expectedId, student);
    }

    @Test
    public void testDeleteStudentService() {
        long expectedId = 1;
        Student student = new Student("Ivan", "Ivanov");
        when(studentDao.save(student)).thenReturn(expectedId);
        doNothing().when(studentDao).delete(expectedId);
        studentService.delete(expectedId);
        verify(studentDao).delete(expectedId);
    }
}