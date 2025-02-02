package kevharv.com.idp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class IdpApplicationTests {

	@Autowired
    private LdapTemplate ldapTemplate;

    @Test
    void testLdapUserExists() {
        boolean userExists = ldapTemplate.authenticate(
                "ou=people",
                "(cn=john.doe)", "secret");

        assertTrue(userExists);
    }

}
