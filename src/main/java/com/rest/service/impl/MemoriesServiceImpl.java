package com.rest.service.impl;

import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.rest.ObjectService;
import com.rest.dao.MemoryDAL;
import com.rest.model.Memory;
import com.rest.service.MemoriesServices;

@Path("data")
public class MemoriesServiceImpl implements MemoriesServices {
	private MemoryDAL memoryDAL = ObjectService.getMemoryDALInstance();

	
	//post with object
	@POST
	@Path("add")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_JSON)
	public Memory createMemory(Memory memory) {
		System.out.println("-----------");
		//"desc" is the key the data will be sent, as 'description' defined to rootelement to 'desc'
		System.out.println(memory.getDescription());
		System.out.println(memory.getCreatedBy());
		System.out.println("-----------");
		
		memory.setId(new Random(10000000).nextInt());
		return memoryDAL.addMemory(memory);
	}

	//post with params
	@POST
	@Path("add")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Memory createMemory(MultivaluedMap<String, String> formParams) {

		String description = formParams.getFirst("description");
		String createdBy = formParams.getFirst("createdBy");

		Memory memory = new Memory();
		memory.setId(new Random().nextInt());
		memory.setDescription(description);
		memory.setCreatedBy(createdBy);

		return memoryDAL.addMemory(memory);
	}

	@GET
	// converting to json, internally object converts to xml and to json
//	@Produces(MediaType.APPLICATION_XML)
//	@Produces(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Memory> getMemories() {
		return memoryDAL.getMemories();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{id}/{createdBy}/memory")
	public Memory getMemory(@PathParam("id") int id, @PathParam("createdBy") String createdBy) {
		return memoryDAL.getMemoryById(id, createdBy);
	}

}
