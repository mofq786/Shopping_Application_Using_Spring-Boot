package com.eShopping.service;

import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class CustomerServiceImpl implements CustomerService
{
	@Override
	public int otpGenrater() {
		Random random = new Random();
		int otp = random.nextInt(1000000);
		if (otp<100000) {
			otp+=100000;
		}
		return otp;
	}

}
