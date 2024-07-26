package com.ztiaa.password;

/**
 * PasswordConfig.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public class PasswordConfig {

	private Integer minLength;

	private Integer minUpperCaseChars;

	private Integer minLowerCaseChars;

	private Integer minDigits;

	private Integer minSpecialChars;

	private Integer maxConsecutiveUserNameChars;

	public Integer getMinLength() {
		return minLength;
	}

	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}

	public Integer getMinUpperCaseChars() {
		return minUpperCaseChars;
	}

	public void setMinUpperCaseChars(Integer minUpperCaseChars) {
		this.minUpperCaseChars = minUpperCaseChars;
	}

	public Integer getMinLowerCaseChars() {
		return minLowerCaseChars;
	}

	public void setMinLowerCaseChars(Integer minLowerCaseChars) {
		this.minLowerCaseChars = minLowerCaseChars;
	}

	public Integer getMinDigits() {
		return minDigits;
	}

	public void setMinDigits(Integer minDigits) {
		this.minDigits = minDigits;
	}

	public Integer getMinSpecialChars() {
		return minSpecialChars;
	}

	public void setMinSpecialChars(Integer minSpecialChars) {
		this.minSpecialChars = minSpecialChars;
	}

	public Integer getMaxConsecutiveUserNameChars() {
		return maxConsecutiveUserNameChars;
	}

	public void setMaxConsecutiveUserNameChars(Integer maxConsecutiveUserNameChars) {
		this.maxConsecutiveUserNameChars = maxConsecutiveUserNameChars;
	}

	public PasswordConfig(Integer minLength, Integer minUpperCaseChars, Integer minLowerCaseChars, Integer minDigits,
			Integer minSpecialChars, Integer maxConsecutiveUserNameChars) {
		super();
		this.minLength = minLength;
		this.minUpperCaseChars = minUpperCaseChars;
		this.minLowerCaseChars = minLowerCaseChars;
		this.minDigits = minDigits;
		this.minSpecialChars = minSpecialChars;
		this.maxConsecutiveUserNameChars = maxConsecutiveUserNameChars;
	}
	
}
