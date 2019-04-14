package com.rest.testUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rest.model.Memory;

public class TestUtil {
	private static List<Memory> memories = null;

	private static void load() {
		memories = new ArrayList<Memory>();
		int id = 0;
		Memory memory = new Memory();
		memory.setId(id++);
		memory.setCreated(new Date());
		memory.setCreatedBy("test1");
		memory.setDescription("asd");
		memories.add(memory);

		memory = new Memory();
		memory.setId(id++);
		memory.setCreated(new Date());
		memory.setCreatedBy("test2");
		memory.setDescription("ding");
		memories.add(memory);
	}

	public static List<Memory> getMemories() {
		populateDataifReq();
		return memories;
	}

	public static Memory getMemoryById(int id, String createdBy) {
		populateDataifReq();
		for (Memory memory : memories) {
			if (createdBy != null && createdBy.equals(memory.getCreatedBy()))
				return memory;
//			else if (id == memory.getId())
//				return memory;
		}
		return null;
	}

	public static Memory createMemory(Memory memory) {
		populateDataifReq();
		Memory newMem = memory != null ? new Memory(memory) : null;
		if (newMem != null)
			memories.add(newMem);
		return newMem;
	}

	private static void populateDataifReq() {
		if (memories == null)
			load();
	}

}
