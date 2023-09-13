package com.example.demofull_stack.Repository;

import com.example.demofull_stack.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

  Optional<Student> findByEmail(String email);

}
