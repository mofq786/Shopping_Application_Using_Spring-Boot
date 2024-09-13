package com.eShopping.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productid;
	private String productname;
	private String category;
	private String brand;
	private double price;
	private int quantity;
	private LocalDate mfdate;
	private LocalDate exdate;
}
