package kevharv.com.idp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kevharv.com.idp.utilities.LDAPAuthenticator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SSOController {
    
    private static final Logger ssoLogger = LoggerFactory.getLogger(SSOController.class);
    
    @Autowired
    LdapTemplate ldapTemplate;
    
    @GetMapping("/sso/login")
    public ModelAndView getLoginView() {

        return new ModelAndView("login");
    }


    @PostMapping(path = "/sso/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView submitLoginCredentials(@RequestParam MultiValueMap<String, String> credentials) {
       
        ssoLogger.info("Submitted Credentials: " + credentials.getFirst("username") + " " + credentials.getFirst("password")); // Don't do this

        String username = credentials.getFirst("username");
        String password = credentials.getFirst("password");

        boolean authenticated = LDAPAuthenticator.authenticateUser(ldapTemplate, username, password);
        ssoLogger.info("User was authenticated: " + authenticated);

        return new RedirectView("/sso/login");  // Testing redirect to hide credentials in browser
    }


    // To-Do - Error page with templating for error message
    // To-Do - ModelAndView for invalid credentials (set template variables depending)
}
