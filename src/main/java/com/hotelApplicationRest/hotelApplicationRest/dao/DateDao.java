package com.hotelApplicationRest.hotelApplicationRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelApplicationRest.hotelApplicationRest.entities.Date;

@Repository
public interface DateDao extends JpaRepository<Date,String>{
	
}
