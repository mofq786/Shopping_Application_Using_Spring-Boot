package com.eShopping.entity;

import jakarta.persistence.Column;
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
public class CustomerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;
	@Column(name = "First_Name",nullable = false,length = 55)
	private String firstname;
	@Column(name = "Last_Name",nullable = false,length = 55)
	private String lastname;
	@Column(name = "Email_Id",nullable = false,unique = true,length = 65)
	private String emailid;
	@Column(name = "Password",nullable = false,unique = true,length = 6)
	private String password;
	@Column(name = "Mobile_Number",nullable = false,unique = true,length = 10)
	private long mobilenumber;
	@Column(name = "Address",nullable = false,length =55)
	private String address;
	@Column(name = "Gender",nullable = false,length =10)
	private String gender;
	

}
