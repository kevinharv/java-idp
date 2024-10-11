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

        return new ModelAndView("login", model);
    }


    @PostMapping(path = "/sso/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView submitLoginCredentials(@RequestParam MultiValueMap<String, String> credentials) {
        
        return new ModelAndView("login");
    }
}
