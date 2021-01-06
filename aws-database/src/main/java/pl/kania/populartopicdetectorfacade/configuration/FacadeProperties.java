package pl.kania.populartopicdetectorfacade.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "pl.kania.facade")
public class FacadeProperties {

    @NotBlank
    private String apiVersion;
    private String pathApiWykop;
    private String pathApiTste;
}
