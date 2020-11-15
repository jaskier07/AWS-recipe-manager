package pl.kania.populartopicdetectorfacade.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kania.populartopicdetectorfacade.configuration.FacadeProperties;

@RestController
@RequestMapping("api")
public class FacadeController {

    @Autowired
    private FacadeProperties facade;
    
    @GetMapping("/version")
    public String version() {
        return facade.getApiVersion();
    }
}
