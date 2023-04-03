package com.movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "payments")
public class Payment {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long paymentId;
   private Double amount;
   private String paymentMode;
   @ManyToOne
   @JoinColumn(name = "booking_id")
   private Booking booking;
   // constructors, getters and setters
}


