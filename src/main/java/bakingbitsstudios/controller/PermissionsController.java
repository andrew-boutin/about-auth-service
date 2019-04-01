package bakingbitsstudios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/permissions")
public class PermissionsController {
    @GetMapping
    public String index() {
        return getGreeting();
    }

    public String getGreeting() {
        return "Greetings from the auth server!";
    }
}
