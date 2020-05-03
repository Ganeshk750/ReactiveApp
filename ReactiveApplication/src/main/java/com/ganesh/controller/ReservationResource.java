package com.ganesh.controller;

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

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResource.ROOM_V1_RESERVATION)
@CrossOrigin
public class ReservationResource {

	public static final String ROOM_V1_RESERVATION = "/room/v1/reservation/";
	
	@GetMapping(path="{roomId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Mono<String> getReservationById(@PathVariable String roomId){
		
		return Mono.just("{}");
		
	}
	
	@PostMapping(path="", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Mono<String> createReservation(@RequestBody Mono<Reservation> reservation){
		
		return Mono.just("{}");
		
	}
	
	@PutMapping(path="{roomId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Mono<String> updatePrice(@PathVariable String roomId, @RequestBody Mono<Reservation> reservation) {
		
		return Mono.just("{}");
	}
	
	@DeleteMapping(path="{roomId}")
	public Mono<Boolean> deleteReservation(@PathVariable String roomId){
		return Mono.just(true);
	}
	
	

}
