package com.codicefiscale.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codicefiscale.entity.Student;

public interface StudentRepositoryDao extends JpaRepository<Student, Long> {

}
