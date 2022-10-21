package com.hug.service.student;

import com.codegym.students.model.Student;
import com.codegym.students.repository.student.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student model) {
        studentRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        studentRepository.remove(id);
    }
}
