package com.ztiaa.password;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-25T20:17:31-0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.1.1.jar, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class PasswordConfigMapperImpl implements PasswordConfigMapper {

    @Override
    public PasswordConfigEntity passwordConfigToPasswordConfigEntity(PasswordConfig passwordConfig) {
        if ( passwordConfig == null ) {
            return null;
        }

        PasswordConfigEntity passwordConfigEntity = new PasswordConfigEntity();

        passwordConfigEntity.setMinLength( passwordConfig.getMinLength() );
        passwordConfigEntity.setMinUpperCaseChars( passwordConfig.getMinUpperCaseChars() );
        passwordConfigEntity.setMinLowerCaseChars( passwordConfig.getMinLowerCaseChars() );
        passwordConfigEntity.setMinDigits( passwordConfig.getMinDigits() );
        passwordConfigEntity.setMinSpecialChars( passwordConfig.getMinSpecialChars() );
        passwordConfigEntity.setMaxConsecutiveUserNameChars( passwordConfig.getMaxConsecutiveUserNameChars() );

        return passwordConfigEntity;
    }

    @Override
    public PasswordConfig passwordConfigEnityToPasswordConfig(PasswordConfigEntity passwordConfigEntity) {
        if ( passwordConfigEntity == null ) {
            return null;
        }

        Integer minLength = null;
        Integer minUpperCaseChars = null;
        Integer minLowerCaseChars = null;
        Integer minDigits = null;
        Integer minSpecialChars = null;
        Integer maxConsecutiveUserNameChars = null;

        minLength = passwordConfigEntity.getMinLength();
        minUpperCaseChars = passwordConfigEntity.getMinUpperCaseChars();
        minLowerCaseChars = passwordConfigEntity.getMinLowerCaseChars();
        minDigits = passwordConfigEntity.getMinDigits();
        minSpecialChars = passwordConfigEntity.getMinSpecialChars();
        maxConsecutiveUserNameChars = passwordConfigEntity.getMaxConsecutiveUserNameChars();

        PasswordConfig passwordConfig = new PasswordConfig( minLength, minUpperCaseChars, minLowerCaseChars, minDigits, minSpecialChars, maxConsecutiveUserNameChars );

        return passwordConfig;
    }
}
