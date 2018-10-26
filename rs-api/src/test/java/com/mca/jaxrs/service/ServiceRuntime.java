package com.mca.jaxrs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.simple.container.SimpleServerFactory;

public class ServiceRuntime {
	
	private static final Logger LOG = LoggerFactory.getLogger(ServiceRuntime.class);
	
	public static void main(String[] args) {
		
		try {
            SimpleServerFactory.create("http://localhost:9091");
            LOG.info("Servidor iniciado!!");
        } catch (Exception ex) {
            LOG.error("Error al arrancar el servidor", ex);
        }

	}

}
