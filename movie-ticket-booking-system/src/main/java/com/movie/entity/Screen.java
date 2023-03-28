package com.movie.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "screens")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long screenId;

	private String screenName;

	@Column(name = "seats_capacity", nullable = false)
	private int seatsCapacity;

	@JsonIgnore
	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
	private List<ShowDetails> show;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theatre_id")
	private Theatre theatre;

	@JsonIgnore
	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
	private List<Seat> seat;

}
