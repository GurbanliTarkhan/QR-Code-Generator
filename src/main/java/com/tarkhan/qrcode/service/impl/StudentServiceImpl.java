package com.tarkhan.qrcode.service.impl;

import com.google.zxing.WriterException;
import com.tarkhan.qrcode.model.student.Student;
import com.tarkhan.qrcode.repository.StudentRepository;
import com.tarkhan.qrcode.service.StudentService;
import com.tarkhan.qrcode.utils.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final QRCodeGenerator qrCodeGenerator;

    @Override
    public List<Student> getStudents() {
        List<Student> students = studentRepository.findAll();
        try {
            if (!students.isEmpty()) {
                for (Student student : students) {
                    qrCodeGenerator.generateQRCode(student);
                }
            }
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student addStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        try {
            qrCodeGenerator.generateQRCode(savedStudent);
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }
        return savedStudent;
    }

    @Override
    public Student findByIdStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found"));
    }
}
