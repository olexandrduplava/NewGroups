package StudentTests;

import com.mygroup.project.dao.StudentDao;
import com.mygroup.project.model.Student;
import com.mygroup.project.service.StudentService;
import com.mygroup.project.service.StudentServiceImp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentTest {

    private StudentServiceImp studentServiceImp;

    @BeforeAll
    public static void BeforeAll(){
        System.out.println("BEFOREALL !@#!@$@!$!@#!%#");
    }

//    @Test
//    public void createStudent(){
//        Student expected = new Student();
//        expected.setFirstName("First1");
//        expected.setLastName("Last1");
//        expected.setId(1L);
//        Student actual = studentServiceImp.save(expected);
//        assertEquals(expected, actual);
//    }

    @BeforeEach
    void BeforeEach(){
        System.out.println("|||||||||||||||||||||||||||");
    }

    @Test
    public void testAdd(){
        System.out.println("test1");
    }

}
