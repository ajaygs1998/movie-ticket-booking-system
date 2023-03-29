package com.movie.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "theaters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long theaterId;

	@Column(name = "theater_name", nullable = false)
	private String theaterName;

   @OneToOne(cascade = CascadeType.ALL, mappedBy = "theater")
	private TheaterLocation theaterLocation;

	@Column(name = "screen_count", nullable = false)
	private int screenCount;

	@JsonIgnore
	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	private Set<Screen> screen;

}
