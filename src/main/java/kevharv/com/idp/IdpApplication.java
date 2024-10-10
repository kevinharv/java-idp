package kevharv.com.idp;

import java.util.logging.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class IdpApplication {

	// Logger logger = LoggerFactory.getLogger(IdpApplication.class);
	private static final Logger logger = LoggerFactory.getLogger(IdpApplication.class);
	
	public static void main(String[] args) {
		logger.info("TEST");		
		SpringApplication.run(IdpApplication.class, args);

		// logger.info("Starting IDP");

        // Connect to LDAP
        // Bind to LDAP
        // Search LDAP
        // Log results

        // logger.info("Shutting down IDP");
	}

	/*
     * Project Overview
     * 
     * 0. Read in configurations (core .properties file, source(s) configs, RP configs)
     * 1. Establish connection to LDAP source (FreeIPA, Active Directory)
     *  - need bind DN, search base DN
     * 2. Create LDAP --> SAML, OIDC attribute mappings
     * 3. Serve web page with login form
     *  - on submit, search for user and then check password with LDAP
     * 4. Run MFA plugins like Duo
     * 5. Handle SAML/OIDC interactions with RPs
     */

}
