package com.ganesh.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Reservation {
	
	private Long roomNumber;
	
	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
	private LocalDate checkIn;
	
	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
	private LocalDate checkOut;
	
	private Integer  price;
	
	@Id
	private String id;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(Long roomNumber, LocalDate checkIn, LocalDate checkOut, Integer price) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.price = price;
	}

	public Long getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Long roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}
	
	
	
	
    
}
