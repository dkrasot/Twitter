package twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import twitter.Tweet;
import twitter.data.TweetRepository;

import java.util.List;

@Controller
@RequestMapping("/tweets")
public class TweetController {
    private TweetRepository tweetRepository;
    @Autowired
    public TweetController(TweetRepository tweet1Repository){
        this.tweetRepository = tweetRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String tweets(Model model){
//        model.addAttribute("twitList",
//                tweet1Repository.findTweets(Long.MAX_VALUE,20));
//        return "tweets";
//    }

//    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);
    @RequestMapping(method = RequestMethod.GET)
    public List<Tweet> tweets(
            @RequestParam(value = "max"//, defaultValue = MAX_LONG_AS_STRING
                        ) long max,
            @RequestParam(value = "count", defaultValue = "20") int count){
        return tweetRepository.findTweets(max, count);
    }


    // URL like /tweets/show?tweet_id=12345
    @RequestMapping(value="/show", method = RequestMethod.GET)
    public String showTwit(@RequestParam("tweet_id") long tweetId, Model model){
        model.addAttribute(tweetRepository.findOne(tweetId));
        return "tweet";
    }

    // URL like /tweets/12345
    @RequestMapping(value = "/{tweetId}", method = RequestMethod.GET)
    public String tweet(@PathVariable long tweetId, Model model){
        model.addAttribute(tweetRepository.findOne(tweetId));
        return "tweet";
    }

}
