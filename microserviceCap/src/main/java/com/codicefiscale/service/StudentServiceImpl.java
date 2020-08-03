package com.codicefiscale.service;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codicefiscale.dao.DepartmentRepositoryDao;
import com.codicefiscale.dao.StudentRepositoryDao;
import com.codicefiscale.entity.Department;
import com.codicefiscale.entity.Student;


@Service
public class StudentServiceImpl implements StudentService {
	final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	
	@Autowired StudentRepositoryDao studentRepositoryDao;
	@Autowired DepartmentRepositoryDao departmentRepositoryDao;
	
	@Override
	public Student saveStudent(Student student) throws EntityNotFoundException {		
		
		return studentRepositoryDao.save(student);
	}
   
	@Override
	public Department saveDepartment(Department dipartimento) throws EntityNotFoundException {
		return departmentRepositoryDao.save(dipartimento);
	}

	@Override
	public Long depId() {
		Long mydep = departmentRepositoryDao.count();
		log.info("departmentRepositoryDao.count----========>"+mydep.toString());
		return mydep;
	}
	
	

}
