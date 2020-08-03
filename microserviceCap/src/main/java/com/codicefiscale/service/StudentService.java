package com.codicefiscale.service;

import javax.persistence.EntityNotFoundException;

import com.codicefiscale.entity.Department;
import com.codicefiscale.entity.Student;

public interface StudentService {
		Student saveStudent(Student student) throws EntityNotFoundException;
		Department saveDepartment(Department dipartimento) throws EntityNotFoundException;
		Long depId();
}
