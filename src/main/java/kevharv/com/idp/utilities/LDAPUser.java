package kevharv.com.idp.utilities;

import org.springframework.ldap.core.AttributesMapper;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.query.SearchScope;
import javax.naming.directory.Attributes;
import javax.naming.NamingException;

import java.util.List;

public class LDAPUser {

    // All attributes, getters, setters, etc. for a user
    String cn;
    String displayName;
    String department;
    String description;
    String distinguishedName;
    

    // Move this somewhere else
    private static class UserAttributesMapper implements AttributesMapper<LDAPUser> {
        @Override
        public LDAPUser mapFromAttributes(Attributes attributes) throws NamingException {

            LDAPUser user = new LDAPUser();
            // return (String) attributes.get("userPrincipalName").get();
            return user; 
        }
    }
}