package com.ztiaa.password.server;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * LDAPServerRepository.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Repository
public interface LDAPServerRepository extends CrudRepository<LDAPServerEntity, Integer> {

	@Query("select s from LDAP_SERVER s where s.enterpriseServerFlag = false")
	List<LDAPServerEntity> findAll();

	LDAPServerEntity findByEnterpriseServerFlagTrue();

}
