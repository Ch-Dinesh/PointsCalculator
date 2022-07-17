package com.charter.points.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	
	private Integer id; 
	private Long totalThreeMonthRewards;
	private List<PointsPerMonth> pointsPerMonth;	

}
