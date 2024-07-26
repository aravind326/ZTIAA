package com.ztiaa.token;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * TokenRepository.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Repository
public interface TokenRepository extends CrudRepository<TokenEntity, Integer> {
	
	TokenEntity findByUserIDAndTokenType(String userID, String tokenType);
	
	TokenEntity findByTokenActivationID(String tokenActivationID);

}
