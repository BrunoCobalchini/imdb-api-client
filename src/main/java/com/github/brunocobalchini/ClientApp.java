package com.github.brunocobalchini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.brunocobalchini.api.ImdbApi;

public class ClientApp {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientApp.class);
	
	public static void main(String[] args) {
		
		ImdbApi client = ImdbApi.buildClient("http://localhost:8080");

		// TODO: Implement this call on the api		
//		String actorId = "nm0001618";
//		Actor actor = client.getActorById(actorId);
//		LOGGER.info("Actor name: ", actor.getName());
	}
}
