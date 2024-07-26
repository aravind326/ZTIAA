package com.ztiaa.notification;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

/**
 * NotificationServiceImpl.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {

	private static final String fileBasePath = "/Users/aravind/Library/CloudStorage/OneDrive-GeorgiaInstituteofTechnology/CS6727/Emails";

	private void writeToFile(String file, String content) throws IOException {
		String fileName = fileBasePath + File.separator + file;
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write(content);

		writer.close();
	}

	@Override
	public void sendInitialNotification(String userID, String activationTokenID, String activationToken) {
		StringBuilder emailBodyBuilder = new StringBuilder();
		emailBodyBuilder.append("User ID: ").append(userID).append("\n");
		emailBodyBuilder.append("Activation URL: localhost:8102/ZTIAA/activate?id=").append(activationTokenID).append("\n");
		emailBodyBuilder.append("One Time Token: ").append(activationToken).append("\n");
		String fileName = userID + ".txt";
		try {
			writeToFile(fileName, emailBodyBuilder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
