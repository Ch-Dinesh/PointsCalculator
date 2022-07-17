package com.charter.points.dto;

import java.time.LocalDate;

import com.charter.points.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTransactionDto {
		
	private Long id;	
	private Double total;
	private String description;
	private LocalDate saveDate;
	private Customer customer;
	private Long rewards;

}
