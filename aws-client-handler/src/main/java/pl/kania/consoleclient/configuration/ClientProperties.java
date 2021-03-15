package pl.kania.consoleclient.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "pl.kania.client")
public class ClientProperties {

    private String apiVersion;
    private String pathApiFacade;
}
