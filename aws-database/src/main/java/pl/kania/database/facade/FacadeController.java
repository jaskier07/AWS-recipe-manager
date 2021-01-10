package pl.kania.database.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kania.database.configuration.AppProperties;

@RestController
@RequestMapping("api")
public class FacadeController {

    @Autowired
    private AppProperties facade;
    
    @GetMapping("/version")
    public String getVersion() {
        return facade.getApiVersion();
    }

    public String getPopularTopic() {
        return null;
    }
}
