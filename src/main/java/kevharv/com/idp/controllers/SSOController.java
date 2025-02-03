package kevharv.com.idp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
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
}
