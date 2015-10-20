package twitter.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class HomeControllerTest {

    //TODO : delete this and left only version with Mock??
    @Test
    public void testHomePage() throws Exception{
        HomeController controller = new HomeController();
        assertEquals("home",controller.home());
    }

    @Test
    public void testHomePageMock() throws Exception{
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }


}
