package pl.kania.populartopicdetectorfacade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import pl.kania.populartopicdetectorfacade.facade.FacadeController;

@SpringBootApplication
public class PopularTopicDetectorFacadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopularTopicDetectorFacadeApplication.class, args);
	}

}
