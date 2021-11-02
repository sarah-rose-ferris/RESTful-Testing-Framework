package com.example.restfultestingframework.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(1l,"John","john.smith@gmail.com", LocalDate.of(1996, Month.JULY,6),25),
                new Student(2l,"Alex","alex.jones@gmail.com", LocalDate.of(1997, Month.FEBRUARY,24),24)
        );
    }
}
