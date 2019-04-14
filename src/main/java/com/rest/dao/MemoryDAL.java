package com.rest.dao;

import java.util.List;

import com.rest.model.Memory;

public interface MemoryDAL {

	public List<Memory> getMemories();

	public Memory getMemoryById(int id, String createdBy); 
	
	public Memory addMemory(Memory memory);
}
