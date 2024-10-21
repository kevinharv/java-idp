package kevharv.com.idp.utilities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.ldap.query.SearchScope;
import org.springframework.stereotype.Component;
import org.springframework.ldap.core.AttributesMapper;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;

@Component
public class LDAPUserSearcher implements CommandLineRunner {

    @Value("${idp.ldap.disabled}")
    private boolean ldapDisabled;

    @Autowired
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

        List<String> users = LDAPTemplate.search(LdapQueryBuilder.query()
                .searchScope(SearchScope.SUBTREE)
                .filter("(&(objectClass=user)(userPrincipalName=*))"),
            new UserAttributesMapper());
        
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
