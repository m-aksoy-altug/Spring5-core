package com.spring.core.repo;


import com.spring.domain.DummyDomain;

public interface DummyRepository {
	public DummyDomain getDummyById(int id);
}
