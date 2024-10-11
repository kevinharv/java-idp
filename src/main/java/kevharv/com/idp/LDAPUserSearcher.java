package kevharv.com.idp;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.stereotype.Component;
import org.springframework.ldap.core.AttributesMapper;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;

@Component
public class LDAPUserSearcher implements CommandLineRunner {

    @Value("${idp.ldap.disabled}")
    private boolean ldapDisabled;
    private final LdapTemplate LDAPTemplate;

    public LDAPUserSearcher(LdapTemplate ldapTemplate) {
        this.LDAPTemplate = ldapTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        if (ldapDisabled) {
            System.out.println("Skipping LDAP print test");
            return;
        }

        EqualsFilter filter = new EqualsFilter("objectclass", "person");

        
        List<String> users = LDAPTemplate.search("", filter.encode(), new UserAttributesMapper());

        System.out.println("Found " + users.size() + " users");
        users.forEach((user) -> System.out.println(user));
    }

    

    private static class UserAttributesMapper implements AttributesMapper<String> {
        @Override
        public String mapFromAttributes(Attributes attributes) throws NamingException {
            return (String) attributes.get("userPrincipalName").get();
        }
    }
}
