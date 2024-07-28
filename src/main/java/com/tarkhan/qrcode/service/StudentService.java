package com.tarkhan.qrcode.service;

import com.tarkhan.qrcode.model.student.Student;

import java.util.List;

public interface StudentService {
        List<Student> getStudents();
        Student addStudent(Student student);
        Student findByIdStudent(Long id);
}
