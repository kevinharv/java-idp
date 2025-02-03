package kevharv.com.idp.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

@RestController
public class APIController {
    @GetMapping("/info")
    public Authentication getAuthentication(Authentication authentication) {
        return authentication;
    }
}
