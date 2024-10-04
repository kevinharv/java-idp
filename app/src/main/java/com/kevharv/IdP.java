package com.kevharv;

public class IdP {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new IdP().getGreeting());


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
