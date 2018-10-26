package com.mca.jaxrs.filters;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

	private static final Logger LOG = LoggerFactory.getLogger(LoggingFilter.class);
	private static final int BUFFER_SIZE = 5000;

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append(" - Header: ").append(responseContext.getHeaders());
		sb.append(" - Entity: ").append(responseContext.getEntity());
		LOG.info("HTTP RESPONSE=[{}]", sb.toString());
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("======SERVER=====\n");
		sb.append("User: ").append(requestContext.getSecurityContext().getUserPrincipal() == null ? "unknown"
				: requestContext.getSecurityContext().getUserPrincipal());
		sb.append("\n");
		sb.append(" - Path: ").append(requestContext.getUriInfo().getPath()).append("\n");
		sb.append(" - Header: ").append(requestContext.getHeaders()).append("\n");
		sb.append(" - Entity: ").append(getEntityBody(requestContext)).append("\n");
		LOG.info("HTTP REQUEST=[{}]", sb.toString());
	}

	private String getEntityBody(ContainerRequestContext requestContext) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = requestContext.getEntityStream();

		final StringBuilder b = new StringBuilder();
		try {
			writeTo(in, out);

			byte[] requestEntity = out.toByteArray();
			if (requestEntity.length == 0) {
				b.append("").append("\n");
			} else {
				b.append(new String(requestEntity)).append("\n");
			}
			requestContext.setEntityStream(new ByteArrayInputStream(requestEntity));

		} catch (IOException ex) {
			// Handle logging error
		}
		return b.toString();
	}

	private static void writeTo(InputStream in, OutputStream out) throws IOException {
		int read;
		final byte[] data = new byte[BUFFER_SIZE];
		while ((read = in.read(data)) != -1) {
			out.write(data, 0, read);
		}
	}

}
