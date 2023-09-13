package com.example.demofull_stack.Service;

import com.example.demofull_stack.Exception.StudentAlreadyExistsException;
import com.example.demofull_stack.Exception.StudentNotFoundException;
import com.example.demofull_stack.Model.Student;
import com.example.demofull_stack.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService implements  IStudentService{

    private final StudentRepository studentRepository;
    @Override
    public Student addStudent(Student student) {

        if(studentAlreadyExists(student.getEmail())){
            throw new StudentAlreadyExistsException((student.getEmail()+" Already Exists"));
        }
        return studentRepository.save(student);
    }

    private boolean studentAlreadyExists(String email) {
        return  studentRepository.findByEmail(email).isPresent();
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentRepository.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found"));


    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Sorry, no student found with the Id :" +id));
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Sorry, student not found");
        }
        studentRepository.deleteById(id);

    }
}
