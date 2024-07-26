package com.ztiaa.password;

/**
 * PasswordConfigEntity.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "PWD_CONFIG")
public class PasswordConfigEntity {
	
	@Id
	@Column(name = "PWD_CONFIG_ID")
	private Integer passwordConfigID = 1;

	@Column(name = "PWD_CONFIG_MINLEN")
	private Integer minLength;

	@Column(name = "PWD_CONFIG_MINUPPERCHARS")
	private Integer minUpperCaseChars;

	@Column(name = "PWD_CONFIG_MIN_LOWERCHARS")
	private Integer minLowerCaseChars;

	@Column(name = "PWD_CONFIG_MINDIGITS")
	private Integer minDigits;

	@Column(name = "PWD_CONFIG_MINSPLCHARS")
	private Integer minSpecialChars;

	@Column(name = "PWD_CONFIG_MACUSERNAMECHARS")
	private Integer maxConsecutiveUserNameChars;

	public Integer getPasswordConfigID() {
		return passwordConfigID;
	}

	public void setPasswordConfigID(Integer passwordConfigID) {
		this.passwordConfigID = passwordConfigID;
	}

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
	
	
	
}
