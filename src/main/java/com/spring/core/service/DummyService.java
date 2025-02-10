package com.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring.core.repo.DummyRepository;
import com.spring.domain.DummyDomain;

public class DummyService {
	
	@Autowired(required = false) // Avoiding run time exceptions, including unSatisfiedDependencyException
	@Qualifier("dummyRepositoryImpl")
	private DummyRepository dummyRepository;
	
	public DummyDomain findById(int id) {
		return dummyRepository.getDummyById(id);
	}

}
