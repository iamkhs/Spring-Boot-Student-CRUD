package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Student;
import com.example.springbootdemo.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService{
    private final StudentRepo studentRepository;

    public StudentService(StudentRepo studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Iterable<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id){
        return studentRepository.findById(id);
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudentById(Integer id){
        studentRepository.deleteById(id);
    }
}
