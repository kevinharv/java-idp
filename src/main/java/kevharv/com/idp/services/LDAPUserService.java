package kevharv.com.idp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kevharv.com.idp.models.LDAPUser;
import kevharv.com.idp.repositories.LDAPUserRepo;

@Service
public class LDAPUserService {

    @Autowired
    private LDAPUserRepo ldapUserRepository;

    public LDAPUser getUserByCn(String cn) {
        return ldapUserRepository.findByCn(cn);
    }
    
}
