package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
