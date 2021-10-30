package com.mygroup.project.controller;

import java.util.List;
import java.util.Set;

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

    /*---Add new student---*/
    @PostMapping("/student")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        studentService.save(student);
        return ResponseEntity.ok().body(student);
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
    public ResponseEntity<Student> update(@PathVariable("id") long id, @RequestBody Student student) {
        studentService.update(id, student);
        return ResponseEntity.ok().body(student);
    }

    /*---Delete a student by id---*/
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
