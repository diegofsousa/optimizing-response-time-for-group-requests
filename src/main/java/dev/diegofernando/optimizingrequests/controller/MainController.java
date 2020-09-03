package dev.diegofernando.optimizingrequests.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.diegofernando.optimizingrequests.service.MainService;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

@RestController
@RequestMapping
public class MainController {

	@Autowired
	private MainService service;

	@GetMapping("/normal")
	public ResponseEntity<?> getNormalRequests() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getNormalRequests());
	}

	@GetMapping("/countdown")
	public ResponseEntity<?> getCountdownRequests() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getCountdownRequests());
	}

	@GetMapping("/future")
	public ResponseEntity<?> getFutureRequests() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getFutureRequests());
	}

	@GetMapping("/async")
	public ResponseEntity<?> getAsyncRequests() throws InterruptedException, ExecutionException, TimeoutException {
		return ResponseEntity.status(HttpStatus.OK).body(service.getFeignRetrofitRequests());
	}

	@GetMapping("/spring-async")
	public ResponseEntity<?> getSpringAsyncRequests()
			throws InterruptedException, ExecutionException, TimeoutException {
		return ResponseEntity.status(HttpStatus.OK).body(service.getSpringAsync());
	}

}
