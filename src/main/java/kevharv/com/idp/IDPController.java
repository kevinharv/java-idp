package kevharv.com.idp;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IDPController {
    
    @GetMapping("/sso/login")
    public ModelAndView getLoginView(Map<String, String> model) {
        
        model.put("title", "Example Single Sign-On");
        model.put("username", "");
        model.put("password", "");

        return new ModelAndView("login", model);
    }


    @PostMapping(path = "/sso/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView submitLoginCredentials(@RequestParam MultiValueMap<String, String> credentials, Map<String, String> model) {
       
        model.put("title", "SSO Submitted");
        model.put("username", credentials.getFirst("username"));
        model.put("password", credentials.getFirst("password"));
        return new ModelAndView("login", model);
    }
}
