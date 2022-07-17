package com.charter.points.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.charter.points.dto.CustomerDto;
import com.charter.points.dto.CustomerTransactionDto;
import com.charter.points.service.IPointsService;

@RestController
public class PointsController {
	
	@Autowired
	private IPointsService pointsService;
	
	/* This endpoint calculate points earned for given transaction and saves to the database.*/
	@PostMapping(path= "/calculatePoints", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerTransactionDto> calculatePoints(@RequestBody CustomerTransactionDto customerTransactionDto) {
		 pointsService.calculatePoints(customerTransactionDto);
		 return new ResponseEntity < >(customerTransactionDto, HttpStatus.CREATED);
	}
	
	/* This endpoint calculate rewards earned each month and total. */
	@PostMapping(path= "/customerPointsPerMonthAndTotal/{date}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<CustomerDto>> calculatePointsPerMonthAndTotal(@PathVariable String date) {
		 List<CustomerDto> customersPoints=pointsService.calculatePointsPerMonthAndTotal(date);
		 return new ResponseEntity < >(customersPoints, HttpStatus.OK);
	}
	
	

}
