package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewDAO {
    private final ReviewRepository reviewRepository;

    public ReviewDAO(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews() {
        List<Review> reviewList = reviewRepository.findAll();
        return reviewList;
    }
}
