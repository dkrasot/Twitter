package twitter.web;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;//mock when;
import static org.hamcrest.CoreMatchers.hasItems;//????
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import twitter.Tweet;
import twitter.data.TweetRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class TweetControllerTest {
    @Test
    public void shouldShowRecentTweets() throws Exception {
        List<Tweet> expectedTweets = createTweetList(20);
        TweetRepository mockRepository = mock(TweetRepository.class);
        when(mockRepository.findTweets(Long.MAX_VALUE, 20))
                .thenReturn(expectedTweets);

        TweetController controller = new TweetController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("WEB-INF/views/tweets.jsp"))
                .build();

        mockMvc.perform(get("/tweets"))
                .andExpect(view().name("tweets"))
                .andExpect(model().attributeExists("tweetList"))
                .andExpect(model().attribute("tweetList",
                        hasItems(expectedTweets.toArray())));
    }

    private List<Tweet> createTweetList(int count){
        List<Tweet> tweets = new ArrayList<Tweet>();
        for(int i=0; i<count;i++){
            tweets.add(new Tweet("Tweet "+i,new Date()));
        }
        return tweets;
    }

    @Test
    public void shouldShowPagedTweets() throws Exception{
        List<Tweet> expectedTweets = createTweetList(50);
        TweetRepository mockRepository = mock(TweetRepository.class);
        when(mockRepository.findTweets(238900,50))
                .thenReturn(expectedTweets);

        TweetController controller = new TweetController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("WEB-INF/views/tweets.jsp"))
                .build();

        mockMvc.perform(get("/tweets?max=238900&count=50"))
                .andExpect(view().name("tweets"))
                .andExpect(model().attributeExists("tweetList"))
                .andExpect(model().attribute("tweetList",
                        hasItems(expectedTweets.toArray())));
    }

    @Test
    public void shouldShowOneTweet() throws Exception {
        Tweet expectedTweet = new Tweet("Hello", new Date());
        TweetRepository mockRepository = mock(TweetRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(expectedTweet);
        TweetController controller = new TweetController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/tweets/12345"))
                .andExpect(view().name("tweet"))
                .andExpect(model().attributeExists("tweet"))
                .andExpect(model().attribute("tweet", expectedTweet));
    }

//    @Test
//    public void saveSpittle() throws Exception{
//        TweetRepository mockRepository = mock(TweetRepository.class);
//        TweetController controller = new TweetController(mockRepository);
//        MockMvc mockMvc = standaloneSetup(controller).build();
//
//        mockMvc.perform(post("/tweets")
//            .param("message","Hello world")
//            .param("longitude","-4.3423")
//            .param("latitude","434.32344"))
//                .andExpect(redirectedUrl("/tweets"));
//    }
}

//todo : import Mockito