package com.spring.core.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.domain.DummyDomain;

@Repository
public class DummyRepositoryImpl implements DummyRepository {
	private static final Map<Integer,DummyDomain> DUMMYDOMAINS= new HashMap<Integer,DummyDomain>();
	static{
		DummyDomain dummyDomain1 = new DummyDomain();
		dummyDomain1.setId(1);
		dummyDomain1.setName("dummyDomain1");
		DummyDomain dummyDomain2 = new DummyDomain();
		dummyDomain2.setId(2);
		dummyDomain2.setName("dummyDomain2");
		DUMMYDOMAINS.put(1, dummyDomain1);
		DUMMYDOMAINS.put(2, dummyDomain2);
	}
	
	@Override
	public DummyDomain getDummyById(int id) {
		DummyDomain result = DUMMYDOMAINS.get(id);
		if(result==null) {
			throw new RuntimeException("Dummy Domain is null...");
		}
		return result;
	}

}
