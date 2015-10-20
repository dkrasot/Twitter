package twitter.web;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//import static org.hamcrest.CoreMatchers.hasItems;//????
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import twitter.data.TwitterRepository;
import twitter.Twitter;

public class TwitterControllerTest {
    @Test
    public void shouldShowRegistration() throws Exception {
        TwitterRepository mockRepository = mock(TwitterRepository.class); //Set up mock repository
        TwitterController controller = new TwitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/twitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        TwitterRepository mockRepository = mock(TwitterRepository.class); //Set up mock repository
        Twitter unsaved = new Twitter("jbauer", "24hours", "Jack", "Bauer", "jbauer@ctu.gov");
        Twitter saved = new Twitter(24L, "jbauer", "24hours", "Jack", "Bauer", "jbauer@ctu.gov");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        TwitterController controller = new TwitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();		//Set up MockMvc

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours")
                .param("email","jbauer@ctu.gov"))
                .andExpect(redirectedUrl("/spitter/jbauer"));

        verify(mockRepository, atLeastOnce()).save(unsaved);	// Verify save
    }

//    @Test
//    public void shouldFailValidationWithNoData() throws Exception{
//        TwitterRepository mockRepository = mock(TwitterRepository.class); //Set up mock repository
//        TwitterController controller = new TwitterController(mockRepository);
//        MockMvc mockMvc = standaloneSetup(controller).build();
//
//        mockMvc.perform(post("/spitter/register"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("registerForm"))
//                .andExpect(model().errorCount(5))
//                .andExpect(model().attributeHasFieldErrors("twitter","firstname","lastname","username","password","email"));
//    }
}
