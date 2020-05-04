package com.github.brunocobalchini.api;

import java.util.Collection;

import com.github.brunocobalchini.model.Actor;
import com.github.brunocobalchini.model.Movie;

import feign.Feign;
import feign.Headers;
import feign.Logger.Level;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

public interface ImdbApi {

	// Rest Api (ACTORS)
	@Headers({"Accept: application/json"})
	@RequestLine("GET /actors/{id}")
	Actor getActorById(@Param("id") String actorId);

	@Headers({"Accept: application/json"})
	@RequestLine("GET /actors")
	Collection<Actor> getAllActors();

	@Headers({"Accept: application/json", "Content-Type: application/json"})
	@RequestLine("POST /actors/{id}")
	Actor postActor(Actor actor, @Param("id") String actorId);

	@Headers({"Accept: application/json", "Content-Type: application/json"})
	@RequestLine("PUT /actors/{id}")
	Actor putActor(Actor actor, @Param("id") String actorId);

	@RequestLine("DELETE /actors/{id}")
	void deleteActorById(@Param("id") String actorId);
	
	// MOVIES
	
	@Headers({"Accept: application/json"})
	@RequestLine("GET /movies/{id}")
	Movie getMovieByid(@Param("id") String movieId);
	
	@Headers({"Accept: application/json"})
	@RequestLine("GET /movies")
	Collection<Movie> getAllMovies();
	
	@Headers({"Accept: application/json", "Content-Type: application/json"})
	@RequestLine("POST /movies/{id}")
	Movie postMovie(Movie movie, @Param("id") String movieId);
	
	@Headers({"Accept: application/json", "Content-Type: application/json"})
	@RequestLine("PUT /movies/{id}")
	Movie putMovie(Movie movie, @Param("id") String movieId);
	
	@RequestLine("DELETE /movies/{id}")
	void deleteMovieById(@Param("id") String movieId);
	
	public static ImdbApi buildClient(String baseUrl) {
		return Feign.builder()
				.logger(new Slf4jLogger())
				.logLevel(Level.FULL)			
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(ImdbApi.class, baseUrl);
	}
}