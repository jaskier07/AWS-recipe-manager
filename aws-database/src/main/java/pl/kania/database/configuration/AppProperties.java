package pl.kania.database.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "pl.kania.dbapp")
public class AppProperties {

    @NotBlank
    private String apiVersion;
}
