package com.ztiaa.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztiaa.util.PasswordUtils;

/**
 * PasswordConfigServiceImpl.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Service("passwordConfigService")
class PasswordConfigServiceImpl implements PasswordConfigService {

	@Autowired
	PasswordConfigRepository passwordConfigRepository;

	@Autowired
	PasswordConfigMapper passwordConfigMapper;

	@Override
	public PasswordConfig getPasswordConfig() {

		PasswordConfig passwordConfigCriteria = passwordConfigMapper
				.passwordConfigEnityToPasswordConfig(passwordConfigRepository.findById(1).get());
		return passwordConfigCriteria;
	}

	@Override
	public void updatePasswordConfig(PasswordConfig passwordConfig) {
		passwordConfigRepository.save(passwordConfigMapper.passwordConfigToPasswordConfigEntity(passwordConfig));
	}

	@Override
	public Boolean validatePasswordAgainstConfig(String userID, String password) {
		PasswordConfig passwordConfig = getPasswordConfig();
		return PasswordUtils.isPasswordValid(passwordConfig, password, password);
	}

}
