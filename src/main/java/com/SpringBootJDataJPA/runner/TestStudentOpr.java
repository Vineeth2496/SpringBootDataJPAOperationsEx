package com.SpringBootJDataJPA.runner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.SpringBootJDataJPA.model.Student;
import com.SpringBootJDataJPA.repo.StudentRepository;
//@Component
public class TestStudentOpr implements CommandLineRunner {
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
		System.out.println("##########################");
		
		Iterable<Student> all=repo.findAll();
		all.forEach(System.out::println);
		
		System.out.println("---------------------------");
		
		boolean exist1=repo.existsById(106);
		boolean exist2=repo.existsById(107);
		System.out.println("Data Exist: "+exist1+ " , "+exist2);
		
		System.out.println("===========================");
		
		Optional<Student> op=repo.findById(107);
		if(op.isPresent()) {
			Student st=op.get();
			System.out.println("DATA FOUND => "+st);
		}
		else {
			System.out.println("NO DATA");
		}
			
		System.out.println("**************************");

		Iterable<Student> list=repo.findAllById(Arrays.asList(101,104,106,108, 111));
		
		Iterator<Student> itr=list.iterator();
		while(itr.hasNext()) {
			Student st=itr.next();
			System.out.println(st);
		}
		
		System.out.println("Total Rows: "+repo.count());
		System.out.println("DONE");

	}

}
