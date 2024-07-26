package com.ztiaa.password.server;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * SCIMServerRepository.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Repository
public interface SCIMServerRepository extends CrudRepository<SCIMServerEntity, Integer> {

}
