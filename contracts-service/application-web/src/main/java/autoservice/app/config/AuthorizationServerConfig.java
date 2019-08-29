package autoservice.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${CLIENT_ID}")
    private String CLIENT_ID;

    @Value("${CLIENT_SECRET}")
    private String CLIENT_SECRET;

    @Value("${GRANT_TYPE_PASSWORD}")
    private String GRANT_TYPE_PASSWORD;

    @Value("${AUTHORIZATION_CODE}")
    private String AUTHORIZATION_CODE;

    @Value("${REFRESH_TOKEN}")
    private String REFRESH_TOKEN;

    @Value("${IMPLICIT}")
    private String IMPLICIT;

    @Value("${SCOPE_READ}")
    private String SCOPE_READ;

    @Value("${SCOPE_WRITE}")
    private String SCOPE_WRITE;

    @Value("${TRUST}")
    private String TRUST;

    @Value("${ACCESS_TOKEN_VALIDITY_SECONDS}")
    private int ACCESS_TOKEN_VALIDITY_SECONDS;

    @Value("${REFRESH_TOKEN_VALIDITY_SECONDS}")
    private int REFRESH_TOKEN_VALIDITY_SECONDS;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

        configurer
                .inMemory()
                .withClient(CLIENT_ID)
                .secret(CLIENT_SECRET)
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
                .refreshTokenValiditySeconds(REFRESH_TOKEN_VALIDITY_SECONDS);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager);
    }
}
