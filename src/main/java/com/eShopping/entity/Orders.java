package com.eShopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Orders {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int orderid;
	private String address;
	private double bill;
	private int customerid;
	private int productid;
	private boolean status;
}
