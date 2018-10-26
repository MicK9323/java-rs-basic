package com.mca.jaxrs.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GETClient {
	
	private static final Logger LOG = LoggerFactory.getLogger(GETClient.class);

	public static void main(String[] args) {
//		URI location = UriBuilder.fromUri("http://localhost:8080/programa/api/programa").build();
//		Client client = ClientBuilder.newClient().register(LoggingClientFilter.class);
//		client.property("jersey.config.client.connectTimeout", 1000);
//		client.property("jersey.config.client.readTimeout", 1000);
//		Response rp = client.target(location).path("/get/01").request(MediaType.APPLICATION_JSON).get();
//		LOG.info("" + rp.readEntity(Programa.class));
//		rp = client.target(location).path("/list").request(MediaType.APPLICATION_JSON).get();
//		LOG.info("" + rp.readEntity(new GenericType<List<Programa>>() {
//		}));
	}

}
