package com.ganesh.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ganesh.model.Reservation;

import reactor.core.publisher.Flux;
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
		
		return reservationMono.flatMap(reservation -> reactiveMongoOperation.findAndModify(
				Query.query(Criteria.where("id").is(id)), 
				Update.update("price", reservation.getPrice()), Reservation.class)
				.flatMap(result -> {
					result.setPrice(reservation.getPrice());
					return Mono.just(result);
				})
				
			);
	}

	@Override
	public Mono<Boolean> deleteReservation(String id) {
	
		return reactiveMongoOperation.remove(
				Query.query(Criteria.where("id").is(id)), Reservation.class)
				    .flatMap(deletedResult -> Mono.just(deletedResult.wasAcknowledged())
				);
	}

	@Override
	public Flux<Reservation> listAllReservations() {
	
		return reactiveMongoOperation.findAll(Reservation.class);
	}

}
