package com.charter.points.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointsPerMonth {
	@JsonIgnore
	private Integer id; 
	private String month;
	private Long totalPoints;

}
