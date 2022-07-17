package com.charter.points.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerTransaction {
	
	@Id
	@GeneratedValue
	private Long id;	
	private Double total;
	private String description;
	private LocalDate saveDate;
	@ManyToOne
	@JoinColumn(name = "customer_id") //foreign key to customer
	private Customer customer;
	private Long rewards;	
	
	
	

}
