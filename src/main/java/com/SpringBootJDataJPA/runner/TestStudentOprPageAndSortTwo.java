package com.SpringBootJDataJPA.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import com.SpringBootJDataJPA.model.Student;
import com.SpringBootJDataJPA.repo.StudentRepository;

@Component
public class TestStudentOprPageAndSortTwo implements CommandLineRunner {
	@Autowired
	private StudentRepository repo;
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Student(101, "INNAYATH KHALIL", 340.00));
		repo.save(new Student(102, "KHAlASH NIKOW", 450.00));
		repo.save(new Student(103, "SNIPER", 560.00));
		repo.save(new Student(104, "TARPIDO", 760.00));
		repo.save(new Student(105, "INNAYATH KHALIL", 340.00));
		repo.save(new Student(106, "KHAlASH NIKOW", 450.00));
		repo.save(new Student(107, "SNIPER", 560.00));
		repo.save(new Student(108, "TARPIDO", 760.00));
		repo.save(new Student(109, "SNIPER", 560.00));
		repo.save(new Student(110, "TARPIDO", 760.00));
		
		//Input (pageable)= number, size
		//Pageable pageable=PageRequest.of(222, 5);
		//Pageable pageable=PageRequest.of(0, 5, Sort.by("stdName", "stdId"));
		Pageable pageable=PageRequest.of(0, 5, Sort.by(Order.asc("stdName"), Order.desc("stdId")));
		//execute qurey
		Page<Student> page=repo.findAll(pageable);
		
		//print output
		
		List<Student> data=page.getContent();
		//System.out.println(data);
		data.forEach(System.out::println);
		
		//meta data
		System.out.println("Is Empty Page? : "+page.isEmpty());
		System.out.println("Is First Page? : "+page.isFirst());
		System.out.println("Is Last Page? : "+page.isLast());
		System.out.println("Next Page?: "+page.hasNext());
		System.out.println("Previous Page?: "+page.hasPrevious());
		System.out.println("Total Pages?: "+page.getTotalPages());
		System.out.println("Current Page Number?: "+page.getNumber());
		System.out.println("Page Size?: "+page.getSize());
		
	}

	
}
