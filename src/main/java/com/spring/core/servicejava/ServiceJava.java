package com.spring.core.servicejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.core.repo.DummyRepository;
import com.spring.domain.DummyDomain;

@Service 
public class ServiceJava {
	
	@Autowired(required = false) // Avoiding run time exceptions, including unSatisfiedDependencyException
	@Qualifier("dummyRepositoryImpl")
	private DummyRepository dummyRepository;
	
	public DummyDomain findById(int id) {
		return dummyRepository.getDummyById(id);
	}
}
