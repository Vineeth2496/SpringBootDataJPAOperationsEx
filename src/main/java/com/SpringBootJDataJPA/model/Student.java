package com.SpringBootJDataJPA.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "stdtab")
public class Student {
	@Id
	@Column(name = "sid")
	@NonNull
	private Integer stdId;
	@Column(name = "sname")
	private String stdName;
	@Column(name = "sfee")
	private Double stdFee;

}
