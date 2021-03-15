package pl.kania.consoleclient.client;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.kania.consoleclient.configuration.ClientProperties;

@AutoConfigureWebClient
@EnableConfigurationProperties(value = ClientProperties.class)
@WebMvcTest(ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testApiVersion() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/version"))
                .andExpect(MockMvcResultMatchers.content().string(
                        Matchers.containsString("Client")
                ));
    }

}