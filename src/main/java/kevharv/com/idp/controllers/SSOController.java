package kevharv.com.idp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SSOController {

    @GetMapping("/sso/login")
    public String login() {
        return "authenticationPage";
    }
}
