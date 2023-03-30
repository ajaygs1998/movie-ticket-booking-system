package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entity.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {

}