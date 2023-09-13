package com.example.demofull_stack.Exception;

public class StudentNotFoundException extends  RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
