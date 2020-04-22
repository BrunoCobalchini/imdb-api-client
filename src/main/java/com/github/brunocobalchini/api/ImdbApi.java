package com.github.brunocobalchini.api;

import feign.Feign;
import feign.Logger.Level;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

public interface ImdbApi {

	// TODO: add request to find an actor by id, using OpenFeign: @RequestLine, @Headers

	public static ImdbApi buildClient(String baseUrl) {
		return Feign.builder()
				.logger(new Slf4jLogger())
                .logLevel(Level.FULL)			
                .encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(ImdbApi.class, baseUrl);
	}

}
