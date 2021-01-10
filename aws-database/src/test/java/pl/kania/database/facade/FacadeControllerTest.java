package pl.kania.database.facade;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.kania.database.configuration.AppProperties;

@EnableConfigurationProperties(value = AppProperties.class)
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