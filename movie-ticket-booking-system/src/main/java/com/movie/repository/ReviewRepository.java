package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entity.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {



}
