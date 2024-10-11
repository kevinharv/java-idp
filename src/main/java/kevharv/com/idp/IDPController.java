package kevharv.com.idp;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IDPController {
    
    @GetMapping("/sso/test")
    public ModelAndView displayTest(Map<String, String> model) {
        String foo = "fdkak;jff";

        model.put("templated", foo);

        return new ModelAndView("index", model);
    }

    // @PostMapping("/")

}
