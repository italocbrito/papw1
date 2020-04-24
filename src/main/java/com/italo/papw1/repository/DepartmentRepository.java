package com.italo.papw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.italo.papw1.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
