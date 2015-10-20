package twitter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
@RequestMapping({"/","/homepage"})
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        return "home";
    }

}
