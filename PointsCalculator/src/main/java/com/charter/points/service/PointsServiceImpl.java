package com.charter.points.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.points.dto.CustomerDto;
import com.charter.points.dto.CustomerTransactionDto;
import com.charter.points.dto.PointsPerMonth;
import com.charter.points.entity.CustomerTransaction;
import com.charter.points.repository.CustomerTransactionRepository;
import com.charter.points.util.ValueMapper;

@Service
public class PointsServiceImpl implements IPointsService {

	@Autowired
	private CustomerTransactionRepository customerTransactionRepository;

	@Override
	public CustomerTransactionDto calculatePoints(CustomerTransactionDto customerTransactionDto) {
		// TODO Auto-generated method stub

		Long points = 0l;
		Double total = customerTransactionDto.getTotal();

		if (total > 50 && total <= 100) {
			points += (total.intValue() - 50) * 1;

		}

		if (total > 100) {
			points += 50; // 1 point for every dollar spent over $50
			points += (total.intValue() - 100) * 2; // 2 points for every dollar spent over $100
		}

		customerTransactionDto.setRewards(points);
		CustomerTransaction customerTransaction = ValueMapper.mapCustomerTransactionDtoToEntity(customerTransactionDto);
		customerTransactionRepository.save(customerTransaction);
		return customerTransactionDto;

	}

	@Override
	public List<CustomerDto> calculatePointsPerMonthAndTotal(String date) {
		List<PointsPerMonth> monthlyPointsList=new ArrayList<>();
		/*As the transactions are given in 3 month period, calling the db 3 times with 31 days increments */
		for (int i = 1; i <= 3; i++) {
			String starDate = date;
			String endDate = LocalDate.parse(starDate).plusDays(31).toString();
			List<Object[]> pointsPerMonth = customerTransactionRepository.pointsPerMonth(starDate, endDate);			
			for (Object object : pointsPerMonth) {
				PointsPerMonth points=new PointsPerMonth();
				Object[] objArray = (Object[]) object;
				points.setId((Integer) objArray[0]);
				points.setMonth((String)objArray[1]);
				points.setTotalPoints((Long) objArray[2]);
				monthlyPointsList.add(points);
			}
			starDate = endDate;
		}
		Map<Integer, List<PointsPerMonth>> collection = monthlyPointsList.stream().collect(Collectors.groupingBy(PointsPerMonth::getId));		
		return ValueMapper.mapMapToCustomerDtoList(collection);
		
	}

}
