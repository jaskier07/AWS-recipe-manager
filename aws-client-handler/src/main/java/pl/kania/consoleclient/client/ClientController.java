package pl.kania.consoleclient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.kania.consoleclient.configuration.ClientProperties;

@RestController
@RequestMapping("api")
public class ClientController {

    private final ClientProperties properties;
    private final RestTemplate restTemplate;

    @Autowired
    public ClientController(ClientProperties properties, RestTemplateBuilder builder) {
        this.properties = properties;
        this.restTemplate = builder
                .rootUri(properties.getPathApiFacade())
                .build();
    }

    @GetMapping("/facade-version")
    public String getFacadeVersion() {
        return restTemplate.getForObject("/version", String.class);
    }

    @GetMapping("/version")
    public String version() {
        return properties.getApiVersion();
    }
}
