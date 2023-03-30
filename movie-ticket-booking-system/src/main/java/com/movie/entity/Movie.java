package com.movie.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movieId;

	@Column(name = "movie_name", nullable = false, unique = true)
	private String movieName;

	@Column(name = "release_date", nullable = false)
	private LocalDate releaseDate;

	@Column(name = "duration", nullable = false)
	private Integer duration;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "genre", nullable = false)
	private String genre;

	@JsonIgnore
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<ShowDetails> showDetails;

	@JsonIgnore
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<Review> review;

}
