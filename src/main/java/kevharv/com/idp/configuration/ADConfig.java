package kevharv.com.idp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
public class ADConfig {
    @Value("${idp.ad.host}")
	String ADHost;

	@Value("${idp.ad.domain}")
	String ADDomain;

    @Bean
	public ActiveDirectoryLdapAuthenticationProvider authenticationProvider() {
		return new ActiveDirectoryLdapAuthenticationProvider(ADDomain, ADHost);
	}
}
