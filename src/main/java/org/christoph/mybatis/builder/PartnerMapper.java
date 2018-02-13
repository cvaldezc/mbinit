package org.christoph.mybatis.builder;

import java.util.List;

import org.christoph.mybatis.model.Partner;

public interface PartnerMapper {
	
	List<Partner> listPerson();
	
	void insert(Partner partner);

}
