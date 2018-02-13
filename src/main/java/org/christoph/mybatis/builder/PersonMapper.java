package org.christoph.mybatis.builder;

import java.util.List;

import org.christoph.mybatis.model.Person;

public interface PersonMapper {
	
	List<Person> listPerson();
	
	void insert(Person person);

}
