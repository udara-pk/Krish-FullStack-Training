package com.udara.rentacar.demoaplication.repository;

import com.udara.rentacar.demoaplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public class StudentRepository extends JpaRepository<Student,Integer>{

}
