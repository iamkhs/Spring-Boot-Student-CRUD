package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Student;
import com.example.springbootdemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get All Students from Database
    @GetMapping("/students")
    public Iterable<Student> getStudents(){
        return studentService.getStudents();
    }

    // Get Student By ID
    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id){
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return student;
    }

    // Add Student
    @PostMapping("/students")
    public void addStudent(@Valid @RequestBody Student student){
        studentService.saveStudent(student);
    }

    // Delete Student By ID
    @DeleteMapping("/students/{id}")
    public void removeStudentById(@PathVariable Integer id){
        if (studentService.getStudentById(id).isPresent()){
            studentService.deleteStudentById(id);
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    // Update Student Data by ID
    @PutMapping("student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student newStudent) {
        Optional<Student> optionalStudent = studentService.getStudentById(id);
        if (optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            student.setName(newStudent.getName());
            student.setEmail(newStudent.getEmail());
            student.setPhoneNumber(newStudent.getPhoneNumber());
            studentService.saveStudent(student);
            return ResponseEntity.ok().build();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
