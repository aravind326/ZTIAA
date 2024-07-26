package com.ztiaa.password;

/**
 * PasswordConfigService.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public interface PasswordConfigService {

	public PasswordConfig getPasswordConfig();

	public void updatePasswordConfig(PasswordConfig passwordConfig);
	
	public Boolean validatePasswordAgainstConfig(String userId, String password);

}
