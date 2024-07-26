package com.ztiaa.notification;

/**
 * NotificationService.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public interface NotificationService {
	
	public void sendInitialNotification(String userID, String activationTokenID, String activationToken);

}
