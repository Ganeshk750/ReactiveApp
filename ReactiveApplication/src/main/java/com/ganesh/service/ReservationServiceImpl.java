package com.ganesh.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;

import com.ganesh.model.Reservation;

import reactor.core.publisher.Mono;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	private final ReactiveMongoOperations reactiveMongoOperation;
	
	@Autowired
	public ReservationServiceImpl(ReactiveMongoOperations reactiveMongoOperation) {
		this.reactiveMongoOperation = reactiveMongoOperation;
	}

	@Override
	public Mono<Reservation> getReservation(String id) {
		return reactiveMongoOperation.findById(id, Reservation.class);
	}

	@Override
	public Mono<Reservation> createReservation(Mono<Reservation> reservationMono) {
		return reactiveMongoOperation.save(reservationMono);
	}

	@Override
	public Mono<Reservation> updateReservation(String id, Mono<Reservation> reservationMono) {
		return null;
	}

	@Override
	public Mono<Boolean> deleteReservation(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
