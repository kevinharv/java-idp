package kevharv.com.idp.repositories;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import kevharv.com.idp.models.LDAPUser;

@Repository
public interface LDAPUserRepo extends LdapRepository<LDAPUser> {

    LDAPUser findByCn(String cn);
}
