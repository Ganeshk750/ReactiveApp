package com.ganesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.model.Reservation;
import com.ganesh.service.ReservationService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResource.ROOM_V1_RESERVATION)
@CrossOrigin
public class ReservationResource {

	public static final String ROOM_V1_RESERVATION = "/room/v1/reservation/";
	
	private ReservationService reservationService;
	
	@Autowired
	public ReservationResource(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping(path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Mono<Reservation> getReservationById(@PathVariable String id){
		
		//return Mono.just("{}");
		
		return reservationService.getReservation(id);
		
	}
	
	@PostMapping(path="", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation){
		
		//return Mono.just("{}");
		
		return reservationService.createReservation(reservation);
		
	}
	
	@PutMapping(path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Mono<Reservation> updatePrice(@PathVariable String id, @RequestBody Mono<Reservation> reservation) {
		
		//return Mono.just("{}");
		return reservationService.updateReservation(id, reservation);
	}
	
	@DeleteMapping(path="{id}")
	public Mono<Boolean> deleteReservation(@PathVariable String id){
		//return Mono.just(true);
		
		return reservationService.deleteReservation(id);
	}
	
	

}
