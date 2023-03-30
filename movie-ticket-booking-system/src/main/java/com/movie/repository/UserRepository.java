package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
