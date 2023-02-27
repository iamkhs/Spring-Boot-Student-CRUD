package com.example.springbootdemo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("STUDENTS")
public class Student {
    @NotEmpty
    private String name;
    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phoneNumber;

    public Student() {
    }

    public Student(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
