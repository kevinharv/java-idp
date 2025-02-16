# Java IdP

*Modern enterprise-scale identity provider for SAML and OAuth/OIDC.*

## Overview



## Roadmap
1. Solidify core implementation
1. Support stateless OIDC services backed by AD
1. Support stateless SAML services backed by AD
1. OpenTelemtry instrumentation
1. Optionally support persistence for additional capabilities
    - Passkey support
    - Support multi-region deployments (probably DB level)


## Deployment
*Eventually DEB, RPM, OCI (GraalVM?), K8s operator*

*K8s operator can manage restarts when configuration updated*

*Would it be possible to achieve a configuration update without reloading the application?*


## Development
### To-Do
- Convert application configuration to YAML
- Persist JWK keypair and load on startup
- Extend CustomUserDetails to include all relevant info
    - Update class name(s) to refer to AD
- Implement OIDC userinfo customizer
- Externalized persistence and configuration management
    - Start with loading configuration files (OIDC Client configurations)
- Create pretty templates for login, error page, maybe others?
    - User info page?
    - Admin pages?
    - Information/status pages?