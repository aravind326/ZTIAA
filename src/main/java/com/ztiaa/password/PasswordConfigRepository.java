package com.ztiaa.password;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * PasswordConfigRepository.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Repository
public interface PasswordConfigRepository extends CrudRepository<PasswordConfigEntity, Integer> {

}
