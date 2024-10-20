package kevharv.com.idp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class IdpApplicationTests {

	@Autowired
    private LdapTemplate ldapTemplate;

    @Test
    void testLdapUserExists() {
        boolean userExists = ldapTemplate.authenticate(
                "ou=people,dc=springframework,dc=org",  // Use the full DN
                "(uid=john.doe)", "secret");

        assertThat(userExists).isTrue();
    }

}
