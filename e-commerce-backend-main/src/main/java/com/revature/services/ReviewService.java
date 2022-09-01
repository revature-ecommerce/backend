package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Product;
import com.revature.models.Review;
import com.revature.repositories.ProductRepository;
import com.revature.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewrepository;
	@Autowired 
	private ProductRepository productrepository;
	
	public ReviewService() {
		
	}
	
	public Review findById(int id) {
		return this.reviewrepository.findById(id);
	}
	
	public List<Review> findByUser(int id){
		return this.reviewrepository.findAllByUser(id);
	}
	
	public List<Review> findbyProduct(int id){
		return this.reviewrepository.findAllByProduct(id);
	}
	
	public void save(Review review) {
		this.reviewrepository.save(review);
	}
	
	public void delete(Review review) {
		this.reviewrepository.delete(review);
	}
	
	public void updateAvg(Review review) {
		Product product = productrepository.getById(review.getProduct());
		double reviewavg = product.getReviewavg();
		int numreviews = reviewrepository.countByProduct(product.getId());
		reviewavg = (review.getScore()+reviewavg*numreviews)/(numreviews+1);
		product.setReviewavg(reviewavg);
	}
}
