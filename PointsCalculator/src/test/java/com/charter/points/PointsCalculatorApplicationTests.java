package com.charter.points;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.charter.points.dto.CustomerDto;
import com.charter.points.dto.CustomerTransactionDto;
import com.charter.points.entity.Customer;
import com.charter.points.entity.CustomerTransaction;
import com.charter.points.repository.CustomerTransactionRepository;
import com.charter.points.service.IPointsService;


@SpringBootTest
class PointsCalculatorApplicationTests {
	
	@Autowired
	private IPointsService pointsService;
	
	@MockBean
	private CustomerTransactionRepository customerTransactionRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void calculatePointsTest() {
		Customer customer=new Customer();
		CustomerTransactionDto customerTransactionDto=new CustomerTransactionDto(23434l,76d,"Produce",LocalDate.of(2022, 5, 29),customer,0l);
		customerTransactionDto.setRewards(26l);
		CustomerTransaction customerTransaction=new CustomerTransaction(); 		
		when(customerTransactionRepository.save(customerTransaction)).thenReturn(customerTransaction);
		assertEquals(customerTransactionDto,pointsService.calculatePoints(customerTransactionDto));
	}
	
	@Test
	public void calculatePointsPerMonthAndTotalTest() {
		
		List<Object[]> list=TestData.pointsPerMonthDbResult();
		List<CustomerDto> rewards=TestData.calculatePointsPerMonthAndTotalResult();
		String startDate="4-1-2022";
		String endDate = LocalDate.parse(startDate).plusDays(31).toString();
		/*db calls should be mocked three times for this test to pass */
		when(customerTransactionRepository.pointsPerMonth(startDate, endDate)).thenReturn(list);
		assertEquals(rewards,pointsService.calculatePointsPerMonthAndTotal(startDate));
		 
	}

}
