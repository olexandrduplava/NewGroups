package com.mygroup.project.service;

import com.mygroup.project.dao.StudentDao;
import com.mygroup.project.model.Student;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
    public void someTest(){

        Student student = new Student();
        student.setId(1L);
        student.setFirstName("AAA");
        student.setLastName("BBB");
        student.setAverageRank(5D);
        /*
        Коли викликається метод гет з любим ід в студент сервіс
        то нам повертає значення, яке задали зверху
         */
        when(studentService.get(anyLong())).thenReturn(student);

        /*Тут ми викликали метот гет з айди, значить минулому ентыты
          присвоївся значення ід = 1L
        */
        Student student2 = studentService.get(1L);

        //Перевірка чи наш ентіті не налл
        Assert.assertNotNull(student2);
        /*
        Перевірка чи вказане імя, яке ми вказали вище сходиться з тим,
         Що ми передали в студент 2
        */
        Assert.assertEquals(student2.getFirstName(), "AAA");

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
//        Set<Student> actualList = Arrays.asList(student1, student2);
        Set<Student> actualList = Set.of(student1,student2);
        when(studentDao.getAll()).thenReturn(actualList);
        Set<Student> expectedList = studentService.getAll();
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
        when(studentDao.update(expectedId,student)).thenReturn(student);
        Assert.assertEquals(student,studentDao.update(expectedId,student));
        verify(studentDao,times(1)).update(expectedId,student);
    }

    @Test
    public void testDeleteStudentService() {
        long expectedId = 1;
        Student student = new Student("Delete", "Service");
        when(studentDao.save(student)).thenReturn(expectedId);
        doNothing().when(studentDao).delete(expectedId);
        studentService.delete(expectedId);
        verify(studentDao).delete(expectedId);
    }
}