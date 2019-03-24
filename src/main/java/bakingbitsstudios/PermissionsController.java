package bakingbitsstudios;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PermissionsController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from the auth server!";
    }
}
