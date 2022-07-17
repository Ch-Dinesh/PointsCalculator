package com.charter.points.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.charter.points.entity.CustomerTransaction;

@Repository
public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Long>{

	@Query("select customer_id, monthname(:startDate), sum(rewards) from CustomerTransaction where saveDate between :startDate and :endDate group by customer_id")
	List<Object[]> pointsPerMonth(@Param("startDate") String startDate, @Param("startDate") String endDate);
}
