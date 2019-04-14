package com.rest;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.rest.client.MemoryClient;
import com.rest.model.Memory;

public class MemoryClientTest {

	@Test
	void testGet() {
		MemoryClient client = new MemoryClient();
		Memory memory = client.get("avima");

		assertNotNull(memory);  
		System.out.println(memory.toString());
	}

}
