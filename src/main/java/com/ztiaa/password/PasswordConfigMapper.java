package com.ztiaa.password;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * PasswordConfigMapper.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.FIELD)
public interface PasswordConfigMapper {

	public PasswordConfigEntity passwordConfigToPasswordConfigEntity(PasswordConfig passwordConfig);

	public PasswordConfig passwordConfigEnityToPasswordConfig(PasswordConfigEntity passwordConfigEntity);

}
