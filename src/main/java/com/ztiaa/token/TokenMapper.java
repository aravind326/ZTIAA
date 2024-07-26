package com.ztiaa.token;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * TokenMapper.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.FIELD)
public interface TokenMapper {

	public Token tokenEnityToToken(TokenEntity tokenEntity);

}
