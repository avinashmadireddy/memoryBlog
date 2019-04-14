package com.rest.dao.impl;

import java.util.List;

import com.rest.dao.MemoryDAL;
import com.rest.model.Memory;
import com.rest.testUtil.TestUtil;

public class MemoryDALImpl implements MemoryDAL {

	public List<Memory> getMemories() {
		return TestUtil.getMemories();
	}

	public Memory getMemoryById(int id, String createdBy) {
		return TestUtil.getMemoryById(id, createdBy);
	}

	public Memory addMemory(Memory memory) {
		return TestUtil.createMemory(memory);

	}
}
