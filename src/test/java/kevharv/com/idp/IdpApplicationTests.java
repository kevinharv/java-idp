package kevharv.com.idp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.test.context.ActiveProfiles;

import kevharv.com.idp.models.LDAPUser;
import kevharv.com.idp.services.LDAPUserService;

@SpringBootTest
@ActiveProfiles("test")
class IdpApplicationTests {

	@Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private LDAPUserService ldapUserService;

    @Test
    void testLdapUserExists() {
        boolean userExists = ldapTemplate.authenticate(
                "ou=people",
                "(cn=john.doe)", "secret");

        assertTrue(userExists);
    }

    @Test
    void testLDAPServiceFind() {
        LDAPUser user = ldapUserService.getUserByCn("john.doe");
        assertNotNull(user);
    }

    @Test
    void testLDAPServiceMap() {
        LDAPUser user = ldapUserService.getUserByCn("john.doe");
        assertEquals(user.getSN(), "Doe");
    }

}
