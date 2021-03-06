package com.github.brunocobalchini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.brunocobalchini.api.ImdbApi;
import com.github.brunocobalchini.model.Actor;
import com.github.brunocobalchini.model.Movie;

public class ClientApp {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientApp.class);

	public static void main(String[] args) {

		ImdbApi client = ImdbApi.buildClient("http://localhost:8080");
		client.deleteActorById("nm0001191"); // DELETE Adam Sandler
		
		String actorId = "nm0001618"; // GET Joaquin Phoenix
		Actor actor = client.getActorById(actorId);
		LOGGER.info("Actor name: {}", actor.getNome());
		
		// CREATE Tom Cruise
		actorId = "nm0000129";
		actor = new Actor();
		actor.setNome("Tom Cruise");
		actor.setBirthDate("1962-07-03");
		client.postActor(actor, actorId);
		
		for (Actor act : client.getAllActors()) {
			LOGGER.info("id: {}, name: {}, birthDate: {}", act.getId(), act.getNome(), act.getBirthDate());
		}
		
		//Movies
		//"Populate"
		
		String movieId = "tt7286456"; // Joker
		Movie movie = client.getMovieByid(movieId);
		LOGGER.info("Movie name: {}", movie.getName());
		
		for (Movie mov : client.getAllMovies()) {
			LOGGER.info("id: {}, name: {}, releaseDate: {}, rating: {}, duration: {}", mov.getId(), mov.getName(), mov.getReleaseDate(), mov.getRating(), mov.getDuration());
	
		}
	}
}





