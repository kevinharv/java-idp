package com.kevharv;

import java.util.logging.*;


public class IDP {

    public final String LDAPHost = "192.168.1.247";
    public final int LDAPPort = 389;
    public final String LDAPBindDN = "CN=SSO Bind,OU=Harvey Users,DC=ad,DC=kevharv,DC=com";
    public final String LDAPBindCredentials = "Testing123";
    public final String LDAPSearchBaseDN = "OU=Harvey Users,DC=ad,DC=kevharv,DC=com";

    public static void main(String[] args) {
        
        Logger logger = Logger.getLogger(IDP.class.getName());
        logger.setLevel(Level.INFO);

        logger.info("Starting IDP");

        // Connect to LDAP
        // Bind to LDAP
        // Search LDAP
        // Log results

        logger.info("Shutting down IDP");
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
