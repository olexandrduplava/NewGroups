package com.mygroup.project.controller;

import java.util.List;

import com.mygroup.project.model.Student;
import com.mygroup.project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

// ===============================================================================
//  https://bushansirgur.in/angular-2-and-spring-mvc-simple-crud-application/
// ===============================================================================

    /*---Add new student---*/
    @PostMapping("/student")
    public ResponseEntity<?> save(@RequestBody Student student) {
        System.out.println("the json value of student is :::::: " + student);
        long id = studentService.save(student);
        return ResponseEntity.ok().body("New Student has been saved with ID:" + id);
    }

    /*---Get a student by id---*/
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> get(@PathVariable("id") long id) {
        Student student = studentService.get(id);
        return ResponseEntity.ok().body(student);
    }

    /*---get all student---*/
    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok().body(students);
    }

    /*---Update a student by id---*/
    @PutMapping("/student/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Student student) {
        studentService.update(id, student);
        return ResponseEntity.ok().body("Student with id: " + id + " has been updated successfully.");
    }

    /*---Delete a student by id---*/
    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        studentService.delete(id);
        return ResponseEntity.ok().body("Student with id:" + id + " has been deleted successfully.");
    }

}
