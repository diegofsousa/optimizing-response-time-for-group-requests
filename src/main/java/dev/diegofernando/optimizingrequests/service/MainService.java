package dev.diegofernando.optimizingrequests.service;

import org.springframework.stereotype.Service;

import dev.diegofernando.optimizingrequests.dto.util.MessageViewDTO;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

@Service
public class MainService {

	public MessageViewDTO getNormalRequests() {
		return new MessageViewDTO("Requisições concluidas", "requests.normal.done");
	}

	public MessageViewDTO getCountdownRequests() {
		return new MessageViewDTO("Requisições concluidas", "requests.countdown.done");
	}

	public MessageViewDTO getFutureRequests() {
		return new MessageViewDTO("Requisições concluidas", "requests.future.done");
	}

}
