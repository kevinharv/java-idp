package kevharv.com.idp.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
public class APIController {
    @GetMapping("/info")
    public Authentication getAuthentication(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/user")
    public UserDetails getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return null;
        }

        return userDetails;
    }
}
