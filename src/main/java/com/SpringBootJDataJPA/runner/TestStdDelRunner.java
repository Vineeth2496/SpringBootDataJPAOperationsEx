package com.SpringBootJDataJPA.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.SpringBootJDataJPA.model.Student;
import com.SpringBootJDataJPA.repo.StudentRepository;
//@Component
public class TestStdDelRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository repo;
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Student(101, "INNAYATH KHALIL", 340.00));
		repo.save(new Student(102, "KHAlASH NIKOW", 450.00));
		repo.save(new Student(103, "SNIPER", 560.00));
		repo.save(new Student(104, "TARPIDO", 760.00));
		System.out.println("-------------Before DELEETE---------");
		repo.findAll().forEach(System.out::println);
		
		//repo.deleteById(102);
		/*
		Student st=new Student();
		st.setStdId(105);
		repo.delete(st);
		*/
		/*
		repo.deleteAll(Arrays.asList(
				new Student(101),
				new Student(103),
				new Student(107)));
		*/
		
		repo.deleteAll();
		System.out.println("---------After DELETE------------");
		repo.findAll().forEach(System.out::println);

	}

}
