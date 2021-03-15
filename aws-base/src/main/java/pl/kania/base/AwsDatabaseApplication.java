package pl.kania.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kania.base.configuration.AppProperties;

@Slf4j
@SpringBootApplication
public class AwsDatabaseApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AwsDatabaseApplication.class, args);
		AppProperties appProperties = ctx.getBean(AppProperties.class);
		log.info("Database application started. Version : " + appProperties.getApiVersion());
	}

}
