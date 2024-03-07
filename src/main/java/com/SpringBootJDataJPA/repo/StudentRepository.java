package com.SpringBootJDataJPA.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.SpringBootJDataJPA.model.Student;

public interface StudentRepository extends 
		//CrudRepository<Student, Integer> {
		PagingAndSortingRepository<Student, Integer>, CrudRepository<Student, Integer>{

}
