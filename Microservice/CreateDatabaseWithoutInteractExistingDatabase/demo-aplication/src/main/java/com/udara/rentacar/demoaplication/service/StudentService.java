package com.udara.rentacar.demoaplication.service;

import com.udara.rentacar.demoaplication.model.Student;

public interface StudentService {
    Student save(Student student);
    public Student fetchStudentById(int id);
}
