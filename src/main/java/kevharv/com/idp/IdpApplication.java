package kevharv.com.idp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IdpApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdpApplication.class, args);


        // Connect to LDAP
        // Bind to LDAP
        // Search LDAP
        // Log results

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
