package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	Review findById(int id);
	List<Review> findAllByUser(int user);
	List<Review> findAllByProduct(int product);
	int countByProduct(int product);
	
	<S extends Review> S save(Review review);
	void delete(Review review);
}
