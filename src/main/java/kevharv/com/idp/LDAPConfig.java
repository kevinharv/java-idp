package kevharv.com.idp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LDAPConfig {
    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://192.168.1.247:389");
        contextSource.setBase("OU=Harvey Users,DC=ad,DC=kevharv,DC=com");
        contextSource.setUserDn("CN=SSO Bind,OU=Harvey Users,DC=ad,DC=kevharv,DC=com");
        contextSource.setPassword("Testing123");

        contextSource.setReferral("follow");

        return contextSource;
    }
    
    @Bean
    public LdapTemplate ldapTemplate(LdapContextSource contextSource) {
        return new LdapTemplate(contextSource);
    }
}
