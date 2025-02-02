package kevharv.com.idp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SSOController {
    
    private static final Logger ssoLogger = LoggerFactory.getLogger(SSOController.class);
    
    @Autowired
    LdapTemplate ldapTemplate;

    @GetMapping("/sso/login")
    public String login() {
        return "authenticationPage";
    }

    @GetMapping("/sso/info")
    public String info() {
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof LdapUserDetails) {
            ssoLogger.info(((LdapUserDetails) authentication.getPrincipal()).getUsername());
        }
        return null;
    }
}
