package com.charter.points.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.charter.points.dto.CustomerDto;
import com.charter.points.dto.CustomerTransactionDto;
import com.charter.points.dto.PointsPerMonth;
import com.charter.points.entity.CustomerTransaction;

public class ValueMapper {
	
	public static CustomerTransaction mapCustomerTransactionDtoToEntity(CustomerTransactionDto customerTransactionDto) {
		CustomerTransaction customerTransaction=new CustomerTransaction();
		customerTransaction.setTotal(customerTransactionDto.getTotal());
		customerTransaction.setDescription(customerTransactionDto.getDescription());
		customerTransaction.setSaveDate(customerTransactionDto.getSaveDate());
		customerTransaction.setCustomer(customerTransactionDto.getCustomer());
		customerTransaction.setRewards(customerTransactionDto.getRewards());
		return customerTransaction;
	}
	
	public static List<CustomerDto> mapMapToCustomerDtoList(Map<Integer, List<PointsPerMonth>> collection) {
		List<CustomerDto> report=new ArrayList<>();
		for(Map.Entry<Integer, List<PointsPerMonth>> entry: collection.entrySet()) {
			CustomerDto customerDto=new CustomerDto();
			customerDto.setId(entry.getKey());
			customerDto.setPointsPerMonth(entry.getValue());
			customerDto.setTotalThreeMonthRewards(entry.getValue().stream().map(pointsPerMoth->pointsPerMoth.getTotalPoints()).mapToLong(points -> points).sum());
			report.add(customerDto);
		}
		return report;
		
	}


}
