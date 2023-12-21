package com.fbs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fbs.demo.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
