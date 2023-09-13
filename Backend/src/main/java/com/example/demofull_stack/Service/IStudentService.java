package com.example.demofull_stack.Service;

import com.example.demofull_stack.Model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

        Student addStudent(Student student);
        List<Student> getStudents();
        Student updateStudent(Student student, Long id);
        Student getStudentById(Long id);
        void deleteStudent(Long id);

}
