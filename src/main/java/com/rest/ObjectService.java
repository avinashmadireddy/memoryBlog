package com.rest;

import com.rest.dao.MemoryDAL;
import com.rest.dao.impl.MemoryDALImpl;

public class ObjectService {

	private static volatile MemoryDAL memoryDAL = null;

	public static MemoryDAL getMemoryDALInstance() {
		if (memoryDAL == null) {// lazy loading;
			synchronized (MemoryDALImpl.class) {// thread safe
				if (memoryDAL == null) {
					memoryDAL = new MemoryDALImpl();
				}
			}
		}
		return memoryDAL;
	}

}
