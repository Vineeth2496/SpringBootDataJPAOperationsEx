package com.SpringBootJDataJPA.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Sort.Order;
import com.SpringBootJDataJPA.model.Student;
import com.SpringBootJDataJPA.repo.StudentRepository;


//@Component
public class TestStudentOprPageAndSort implements CommandLineRunner {

	@Autowired
	private StudentRepository repo;
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Student(101, "INNAYATH KHALIL", 340.00));
		repo.save(new Student(102, "KHAlASH NIKOW", 450.00));
		repo.save(new Student(103, "SNIPER", 560.00));
		repo.save(new Student(104, "TARPIDO", 760.00));
		
		System.out.println("£££££££££££££££££££££££££££");
		
		repo.saveAll(List.of(
				new Student(105, "BOW", 780.00),
				new Student(106, "JAWAL", 890.00)));
		
		repo.findAll().forEach(System.out::println);
		System.out.println("##########################");
		//Sort s1=Sort.by("stdName");		//ASC
		//Sort  s1=Sort.by(Direction.ASC,"stdName");	//ASC
		//Sort  s1=Sort.by(Direction.DESC,"stdName", "stdFee");
		Sort s1=Sort.by(Order.asc("stdName"), Order.desc("stdFee"));
		
		repo.findAll(s1).forEach(System.out::println);
	}

}
