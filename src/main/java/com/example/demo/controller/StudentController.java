package com.example.demo.controller;

import java.util.List;

import com.example.demo.bean.Student;
import com.example.demo.database.DatabaseAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    private DatabaseAccess db;

    @GetMapping
    public List<Student> getStudentCollection() 
    {
        return db.findAll();
    }

    @GetMapping(value = "/{id}")  // "value" only here to illustrate our Mappings can do more!
    public Student getIndividualStudent(@PathVariable Long id) {
        return db.findById(id);
    }

    @PostMapping(consumes = "application/json")
    public Long postStudent(@RequestBody Student student) {
        return db.save(student);
    }
}


