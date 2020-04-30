package com.github.brunocobalchini.api;

import java.util.Collection;

import com.github.brunocobalchini.model.Actor;

import feign.Feign;
import feign.Headers;
import feign.RequestLine;
import feign.Logger.Level;
import feign.Param;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

public interface ImdbApi {

	@Headers({"Accept: application/json"})
	@RequestLine("GET /actors/{id}")
	Actor getActorById(@Param("id")String actorId);
	
	@Headers({"Accept: application/json"})
	@RequestLine("GET /actors")
	Collection<Actor> getAllActors();
	
	@Headers({"Accept: application/json"})
	@RequestLine("POST /actors/{id}")
	Actor setActorById(@Param("id")String actorId);
	
//	@Headers({"Accept: application/json"})
//	@RequestLine("POST /actors")
//	Collection<Actor> setAllActors();
//	
	
	public static ImdbApi buildClient(String baseUrl) {
		return Feign.builder()
				.logger(new Slf4jLogger())
                .logLevel(Level.FULL)			
                .encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(ImdbApi.class, baseUrl);
	}

}