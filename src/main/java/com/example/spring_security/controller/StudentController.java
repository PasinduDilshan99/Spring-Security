package com.example.spring_security.controller;

import com.example.spring_security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "John", "XXXXXXXXXXXXXX"),
                    new Student(2, "Jane", "XXXXXXXXXXXXXX"),
                    new Student(3, "Jack", "XXXXXXXXXXXXXX")
            )
    );

    @GetMapping(path = "/get-all")
    public List<Student> getAllStudents() {
        logger.info("getAllStudents");
        return students;
    }

    @GetMapping(path = "/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest) {
        logger.info("getCsrfToken");
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

    @PostMapping(path = "/add")
    public Student addStudent(@RequestBody Student student) {
        logger.info("addStudent");
        students.add(student);
        return student;
    }

}
