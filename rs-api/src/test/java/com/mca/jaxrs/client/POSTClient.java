package com.mca.jaxrs.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class POSTClient {

	private static final Logger LOG = LoggerFactory.getLogger(POSTClient.class);

	public static void main(String[] args) {

//		URI location = UriBuilder.fromUri("http://localhost:9090/programa").build();
//		ClientConfig config = new DefaultClientConfig();
//		Client client = Client.create(config);
//		WebResource service = client.resource(location);
//		Programa programa = new Programa("03", "Java Architect", 45.0, new GregorianCalendar(2015, 06, 30).getTime(),
//				new GregorianCalendar(2015, 10, 30).getTime());
//		ClientResponse response = service.path("create").type(MediaType.TEXT_XML).post(ClientResponse.class, programa);
//		LOG.info("HTTP status=[{}]", response.getStatus());
//		LOG.info("HTTP response=[{}]", response.getClientResponseStatus());
//		Iterator<List<String>> iterator = response.getHeaders().values().iterator();
//		while (iterator.hasNext()) {
//			LOG.info("HTTP Header:[{}]", iterator.next());
//		}

	}

}
