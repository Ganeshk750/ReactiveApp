package com.ganesh.controller;

import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.ganesh.model.Reservation;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservationResourceTest {
	
	@Autowired
	private static ApplicationContext context;
	private static WebTestClient webTestClient;
	private static Reservation reservation;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		webTestClient = WebTestClient.bindToApplicationContext(context).build();
		
		reservation = new Reservation(123l, LocalDate.now(), LocalDate.now().plus(10, ChronoUnit.DAYS), 150);
	}

	@Test
	public void testCreateReservation() {
		//fail("Not yet implemented");
		webTestClient.get()
		  .uri("/room/v1/reservation/")
		  .exchange()
		  .expectStatus().isOk()
		  .expectBodyList(Reservation.class);
		  
	}

	@Test
	public void testGetAllReservation() {
		//fail("Not yet implemented");
		webTestClient.post()
		  .uri("/room/v1/reservation/")
		  .body(Mono.just(reservation), Reservation.class)
		  .exchange()
		  .expectStatus().isOk()
		  .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		  .expectBody(Reservation.class);
	}

}
