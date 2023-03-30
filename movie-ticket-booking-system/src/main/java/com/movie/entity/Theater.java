package com.movie.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

	@Column(name = "street", nullable = false)
	private String street;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "state", nullable = false)
	private String state;
	@Column(name = "zip", nullable = false)
	private String zip;

	@Column(name = "latitude", nullable = false)
	private double latitude;
	@Column(name = "longitude", nullable = false)// horizontal lines
	private double longitude;
	
   
 
	@Column(name = "screen_count", nullable = false)
	private int screenCount;

	@JsonIgnore
	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	private Set<Screen> screen;

}
