package com.charter.points.service;

import java.util.List;

import com.charter.points.dto.CustomerDto;
import com.charter.points.dto.CustomerTransactionDto;

public interface IPointsService {
	public CustomerTransactionDto calculatePoints(CustomerTransactionDto customerTransactionDto);
	public List<CustomerDto> calculatePointsPerMonthAndTotal(String date);
}
