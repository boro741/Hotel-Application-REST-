package com.hotelApplicationRest.hotelApplicationRest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelApplicationRest.hotelApplicationRest.dao.DateDao;

@Service
public class DateServiceImpl implements DateService{

	@Autowired
	private DateDao dateDao;
	
	@Override
	public void addDate(String date) {
		
		System.out.println("Date added: "+date);
	}

}
