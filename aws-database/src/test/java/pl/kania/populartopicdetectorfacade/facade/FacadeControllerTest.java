package pl.kania.populartopicdetectorfacade.facade;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.kania.populartopicdetectorfacade.configuration.FacadeProperties;

@EnableConfigurationProperties(value = FacadeProperties.class)
@WebMvcTest(FacadeController.class)
class FacadeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVersion() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/version"))
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.containsString("Facade")
                ));
    }

}