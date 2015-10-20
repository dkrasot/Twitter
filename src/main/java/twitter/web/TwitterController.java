package twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import twitter.Twitter;
import twitter.data.TwitterRepository;

import javax.validation.Valid;

//spitter
@Controller
@RequestMapping("/twitter")
public class TwitterController {
    private TwitterRepository twitterRepository;
    @Autowired
    public TwitterController(TwitterRepository twitterRepository){
        this.twitterRepository = twitterRepository;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(){//Model model){
        //???model.addAttribute(new Twitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegistrationForm(@Valid Twitter twitter,
                                          Errors errors){
        if(errors.hasErrors()){
            return "registerForm";
        }
        twitterRepository.save(twitter);
        return "redirect:/twitter/" + twitter.getUsername(); //page of Profile
    }
    // catches redirect to  /twitter/{username}
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showTwitterProfile(@PathVariable String username, Model model){
        Twitter twitter = twitterRepository.findByUsername(username);
        model.addAttribute(twitter);
        return "profile";
    }
}
