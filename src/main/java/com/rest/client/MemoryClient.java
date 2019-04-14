package com.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.rest.model.Memory;

public class MemoryClient {
	private Client client;

	public MemoryClient() {
		client = ClientBuilder.newClient();
	}

	public Memory get(String createdBy) {
		WebTarget target = client.target("http://localhost:8080/memories/");

		Memory response = target.path("data/" + 0 + "/" + createdBy + "/memory").request().get(Memory.class);

		return response;
	}
}
