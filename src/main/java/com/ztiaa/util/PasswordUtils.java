package com.ztiaa.util;

import com.ztiaa.password.PasswordConfig;

/**
 * PasswordUtils.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public class PasswordUtils {

	private static Integer countPasswordDigits(String password) {
		int digits = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i)))
				digits++;
		}
		return digits;
	}

	private static Integer countPasswordUpperCaseChars(String password) {
		int upperCaseChars = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i)))
				upperCaseChars++;
		}
		return upperCaseChars;
	}

	private static Integer countPasswordLowerCaseChars(String password) {
		int lowerCaseChars = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i)))
				lowerCaseChars++;
		}
		return lowerCaseChars;
	}

	private static Integer countPasswordSpecialChars(String password) {
		int specialChars = password.replaceAll("[A-Za-z0-9\\s]", "").length();
		return specialChars;
	}

	private static Boolean hasNConsecutiveUsernameChars(String username, String password, Integer maxAllowed) {
		for (int i = 0; i < username.length() - maxAllowed; i++) {
			if (password.contains(username.substring(i, i + maxAllowed))) {
				return false;
			}
		}
		return true;
	}

	public static Boolean isPasswordValid(PasswordConfig passwordConfig, String username, String password) {
		if (password.length() < passwordConfig.getMinLength()) {
			return false;
		}
		if (countPasswordSpecialChars(password) < passwordConfig.getMinSpecialChars()) {
			return false;
		}
		if (countPasswordDigits(password) < passwordConfig.getMinDigits()) {
			return false;
		}
		if (countPasswordLowerCaseChars(password) < passwordConfig.getMinLowerCaseChars()) {
			return false;
		}
		if (countPasswordUpperCaseChars(password) < passwordConfig.getMinUpperCaseChars()) {
			return false;
		}
		if (hasNConsecutiveUsernameChars(username, password, passwordConfig.getMaxConsecutiveUserNameChars())) {
			return false;
		}
		return true;
	}
}
