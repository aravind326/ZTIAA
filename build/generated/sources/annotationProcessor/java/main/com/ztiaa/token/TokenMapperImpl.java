package com.ztiaa.token;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-25T20:17:31-0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.1.1.jar, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class TokenMapperImpl implements TokenMapper {

    @Override
    public Token tokenEnityToToken(TokenEntity tokenEntity) {
        if ( tokenEntity == null ) {
            return null;
        }

        Token token = new Token();

        token.setTokenID( tokenEntity.getTokenID() );
        token.setUserID( tokenEntity.getUserID() );
        token.setTokenType( tokenEntity.getTokenType() );
        token.setTokenUsed( tokenEntity.getTokenUsed() );
        token.setTokenInvalidCounter( tokenEntity.getTokenInvalidCounter() );
        token.setTokenLocked( tokenEntity.getTokenLocked() );
        token.setTokenLockedTill( tokenEntity.getTokenLockedTill() );
        token.setTokenExpiryTimestamp( tokenEntity.getTokenExpiryTimestamp() );

        return token;
    }
}
