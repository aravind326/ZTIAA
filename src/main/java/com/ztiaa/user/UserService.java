package com.ztiaa.user;

import java.util.List;

/**
 * UserService.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public interface UserService {
	
	public List<User> getUsersForManager(String managerID);
	
	public User getUserDetails(String userID);
	
	public void updateUserPassword(String userID, String password);

}
