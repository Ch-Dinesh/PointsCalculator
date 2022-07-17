package com.charter.points;

import java.util.ArrayList;
import java.util.List;

import com.charter.points.dto.CustomerDto;
import com.charter.points.dto.PointsPerMonth;

public class TestData {
	
	public static List<Object[]> pointsPerMonthDbResult(){
		List<Object[]> list=new ArrayList<>();
		Object[] rewardsPerMonth={1,"APRIL",120};
		list.add(rewardsPerMonth);
		rewardsPerMonth=new Object[]{1, "MAY", 200 };		
		list.add(rewardsPerMonth);
		rewardsPerMonth=new Object[]{2, "JUNE", 800 };
		list.add(rewardsPerMonth);
		return list;
	}
	
	public static List<CustomerDto> calculatePointsPerMonthAndTotalResult(){
		/* The below test data should be ideally taken from JSON using Jackson */
		PointsPerMonth pointsPerMonth=new PointsPerMonth();		
		List<PointsPerMonth> points=new ArrayList<>();
		CustomerDto customerDto=new CustomerDto();	
		List<CustomerDto> rewards=new ArrayList<>();
		pointsPerMonth.setId(1);
		pointsPerMonth.setMonth("APRIL");
		pointsPerMonth.setTotalPoints(120l);
		points.add(pointsPerMonth);
		pointsPerMonth.setId(1);
		pointsPerMonth.setMonth("MAY");
		pointsPerMonth.setTotalPoints(200l);
		points.add(pointsPerMonth);
		customerDto.setId(1);
		customerDto.setTotalThreeMonthRewards(320l);
		customerDto.setPointsPerMonth(points);
		rewards.add(customerDto);
		points=new ArrayList<>();
		pointsPerMonth.setId(2);
		pointsPerMonth.setMonth("JUNE");
		pointsPerMonth.setTotalPoints(800l);
		points.add(pointsPerMonth);
		customerDto.setId(2);
		customerDto.setTotalThreeMonthRewards(800l);
		customerDto.setPointsPerMonth(points);
		rewards.add(customerDto);
		
		return rewards;
	}

}
