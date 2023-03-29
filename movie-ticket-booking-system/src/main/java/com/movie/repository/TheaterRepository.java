package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

//	@Query("SELECT p FROM Theatre p WHERE CONCAT(p.theatreName,' ', p.theatreLocation) LIKE %?1%")
//	List<Theater> findByKeyword(String theatre);
}
