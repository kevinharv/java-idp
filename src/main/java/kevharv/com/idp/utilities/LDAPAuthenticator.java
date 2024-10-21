package kevharv.com.idp.utilities;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

import org.springframework.ldap.support.LdapUtils;
// import org.springframework.ldap.core.AttributesMapper;
// import javax.naming.NamingException;
// import javax.naming.directory.Attributes;


public class LDAPAuthenticator {

    public static boolean authenticateUser(LdapTemplate ldapTemplate, String username, String password) {

        AndFilter filter = new AndFilter();
        filter.and(new EqualsFilter("objectClass", "person"));
        filter.and(new EqualsFilter("sAMAccountName", username));
        boolean authenticated = ldapTemplate.authenticate(LdapUtils.emptyLdapName(), filter.toString(), password);

        return authenticated;
    }
}
