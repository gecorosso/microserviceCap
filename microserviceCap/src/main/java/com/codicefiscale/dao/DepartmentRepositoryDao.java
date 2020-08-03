package com.codicefiscale.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codicefiscale.entity.Department;

public interface DepartmentRepositoryDao extends JpaRepository<Department, Long>{

}
